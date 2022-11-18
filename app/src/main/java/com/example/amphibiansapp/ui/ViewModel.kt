package com.example.amphibiansapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibiansapp.data.repository.AmphibianRepository
import com.example.amphibiansapp.domain.modal.AmphibiansData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: AmphibianRepository
):ViewModel() {
    private val _amphibians: MutableStateFlow<List<AmphibiansData>>  = MutableStateFlow(listOf())
    val amphibians: StateFlow<List<AmphibiansData>> = _amphibians

    init {
        getAmphibians()
    }

    private fun getAmphibians() {
        viewModelScope.launch {

            _amphibians.value = repository.getAmphibians()
            Log.d("Viewmodel from Amphibians: ", _amphibians.value.toString())
        }
    }
}