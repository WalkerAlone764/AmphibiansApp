package com.example.amphibiansapp.ui.Screen

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.Coil
import coil.compose.AsyncImage
import com.example.amphibiansapp.domain.modal.AmphibiansData
import com.example.amphibiansapp.ui.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianApp() {
    val viewmodel = hiltViewModel<ViewModel>()
    val amphibians by viewmodel.amphibians.collectAsState()
    Scaffold(
        topBar = { AmphibianTopBar()},

    ) { innerPadding ->
        

       Box(modifier = Modifier.padding(innerPadding)) {
           AmphibianListScreen(amphibians = amphibians)
       }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianTopBar() {
    TopAppBar(
        title = { Text(text = "Amphibians ") },
    )
}


@Composable
fun AmphibianListScreen(
    amphibians: List<AmphibiansData>,
    modifier: Modifier = Modifier
) {
    LazyColumn() {
        items(amphibians) { oneAmphibian ->
            AmphibianCard(amphibian = oneAmphibian, modifier = Modifier.padding(4.dp))
        }
    }
}


@Composable
fun AmphibianCard(
    amphibian: AmphibiansData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
           Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = amphibian.name + " (" + amphibian.type + ")",
                textAlign = TextAlign.Center,
                fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )
//            Spacer(modifier = Modifier.height(8.dp))
            Text(text = amphibian.description, modifier = modifier
                .padding(16.dp),
                softWrap = true,
                textAlign =  TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(4.dp))
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
//                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

        }

    }
}

@Composable
@Preview
fun CardPreview() {
    AmphibianCard(amphibian = AmphibiansData(
        name = "jacky is the best",
        type = "Caption",
        imgSrc = "",
        description = "Welcome to the world of Jack Sparrow"
    ))
}