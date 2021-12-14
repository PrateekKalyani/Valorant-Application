package com.example.retrofitapplication.domain

import com.example.retrofitapplication.data.ValorantRepository
import com.example.retrofitapplication.models.UiEvents
import com.example.retrofitapplication.models.ValorantModel
import com.example.retrofitapplication.models.ValorantResponse
import javax.inject.Inject

class ValorantUseCase
@Inject
constructor(
    private val valorantRepository: ValorantRepository,
    private val util: com.example.retrofitapplication.util.Util
) {

    suspend fun getAgents() : UiEvents<List<ValorantModel>> {

        return when(val response = valorantRepository.getAgents(util.checkForInternet())) {

            is ValorantResponse.Success -> {
                UiEvents.Success(result = response.result)
            }

            is ValorantResponse.Error -> {
                UiEvents.Error(response.error)
            }

            is ValorantResponse.Loading -> {
                UiEvents.Loading
            }
        }
    }
}