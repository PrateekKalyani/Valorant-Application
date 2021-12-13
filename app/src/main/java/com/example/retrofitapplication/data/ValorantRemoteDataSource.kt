package com.example.retrofitapplication.data

import com.example.retrofitapplication.models.UiEvents
import com.example.retrofitapplication.models.ValorantModel
import javax.inject.Inject

interface ValorantRemoteDataSource {

    suspend fun getAgents() : UiEvents<List<ValorantModel>>
}

class ValorantRemoteDataSourceImpl
@Inject
constructor(
    private val valorantApiService: ValorantApiService
) : ValorantRemoteDataSource {

    override suspend fun getAgents(): UiEvents<List<ValorantModel>> {

        return try {

            val response = valorantApiService.getNews()

            if(response.isSuccessful) {
                UiEvents.Success(response.body()!!.agentsList)
            } else {
                UiEvents.Error("Sever Down")
            }

        } catch (e : Exception) {
            UiEvents.Error("Server error")
        }
    }
}