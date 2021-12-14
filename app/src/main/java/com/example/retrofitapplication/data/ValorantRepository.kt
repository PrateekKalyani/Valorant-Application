package com.example.retrofitapplication.data

import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.models.ValorantResponse
import javax.inject.Inject

interface ValorantRepository {

    suspend fun getAgents(isConnected: Boolean) : ValorantResponse
}

class ValorantRepositoryImpl
@Inject
constructor(
    private val valorantRemoteDataSource: ValorantRemoteDataSource,
    private val valorantCacheDataSource: ValorantCacheDataSource,
    private val cacheMapper: CacheMapper
) : ValorantRepository {

    override suspend fun getAgents(isConnected: Boolean): ValorantResponse {

        return if(isConnected) {
            val response = valorantRemoteDataSource.getAgents()

            if(response is ValorantResponse.Success) {
                valorantCacheDataSource.saveAgents(
                    agentList = cacheMapper.mapToEntityList(
                        domainModelList = response.result
                    )
                )
            }
            response
        } else {
            val response = valorantCacheDataSource.getAgents()

            if(response.isEmpty()) {
                ValorantResponse.Error(error = "Empty Cache Data")
            } else {
                ValorantResponse.Success(result = cacheMapper.mapFromEntityList(response))
            }
        }
    }
}
