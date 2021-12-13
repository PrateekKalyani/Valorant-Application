package com.example.retrofitapplication.data

import com.example.retrofitapplication.models.UiEvents
import com.example.retrofitapplication.models.ValorantModel
import com.example.retrofitapplication.models.ValorantResponse
import retrofit2.Response
import javax.inject.Inject

interface ValorantRemoteDataSource {

    suspend fun getAgents() : ValorantResponse
}

class ValorantRemoteDataSourceImpl
@Inject
constructor(
    private val valorantApiService: ValorantApiService
) : ValorantRemoteDataSource {

    override suspend fun getAgents(): ValorantResponse {

        return try {

            val response = valorantApiService.getAgents()

            if(response.isSuccessful) {
                ValorantResponse.Success(result = response.body()!!.agentsList)
            } else {
                ValorantResponse.Error(error = "Something went wrong, please try again")
            }

        } catch (e : Exception) {
            ValorantResponse.Error(error = "Unable to connect to the Server")
        }
    }
}