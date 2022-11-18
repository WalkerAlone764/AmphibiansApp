package com.example.amphibiansapp.data.remote

import com.example.amphibiansapp.domain.modal.AmphibiansData
import retrofit2.http.GET

interface AmphibiansApi {
    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibiansData>
}