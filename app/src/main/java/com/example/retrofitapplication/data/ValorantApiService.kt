package com.example.retrofitapplication.data

import com.example.retrofitapplication.models.ValorantResponse
import retrofit2.Response
import retrofit2.http.GET

interface ValorantApiService {

    @GET(value = "agents")
    suspend fun getNews() : Response<ValorantResponse>
}