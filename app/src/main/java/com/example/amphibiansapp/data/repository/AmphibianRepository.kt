package com.example.amphibiansapp.data.repository

import com.example.amphibiansapp.data.remote.AmphibiansApi
import com.example.amphibiansapp.domain.modal.AmphibiansData

class AmphibianRepository(
    private val AmlphibianApi: AmphibiansApi
): AmphibiansApi {
    override suspend fun getAmphibians(): List<AmphibiansData> {
        return AmlphibianApi.getAmphibians()
    }
}