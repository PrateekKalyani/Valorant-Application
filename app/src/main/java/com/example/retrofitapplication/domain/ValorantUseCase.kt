package com.example.retrofitapplication.domain

import com.example.retrofitapplication.data.ValorantRepository
import com.example.retrofitapplication.models.ValorantResponse
import javax.inject.Inject

class ValorantUseCase
@Inject
constructor(
    private val valorantRepository: ValorantRepository,
    private val util: com.example.retrofitapplication.util.Util
) {

    suspend fun getAgents() : ValorantResponse {
        return valorantRepository.getAgents(util.checkForInternet())
    }
}