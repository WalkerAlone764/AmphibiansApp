package com.example.amphibiansapp.di

import com.example.amphibiansapp.data.remote.AmphibiansApi
import com.example.amphibiansapp.data.repository.AmphibianRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideApi():AmphibiansApi {
        return Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(AmphibiansApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api: AmphibiansApi): AmphibianRepository {
        return AmphibianRepository(api)
    }
}