package com.example.retrofitapplication.data

import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.models.UiEvents
import com.example.retrofitapplication.models.ValorantModel
import javax.inject.Inject

interface ValorantRepository {

    suspend fun getAgents(isConnected: Boolean) : UiEvents<List<ValorantModel>>
}

class ValorantRepositoryImpl
@Inject
constructor(
    private val valorantRemoteDataSource: ValorantRemoteDataSource,
    private val valorantCacheDataSource: ValorantCacheDataSource,
    private val cacheMapper: CacheMapper
) : ValorantRepository {

    override suspend fun getAgents(isConnected: Boolean): UiEvents<List<ValorantModel>> {

        return if(isConnected) {
            val response = valorantRemoteDataSource.getAgents()

            if(response is UiEvents.Success) {
                valorantCacheDataSource.saveAgents(
                    cacheMapper.mapToEntityList(
                        response.result
                    )
                )
            }
            response
        } else {
            val response = valorantCacheDataSource.getAgents()

            if(response.isEmpty()) {
                UiEvents.Error("Empty Cache Data")
            } else {
                UiEvents.Success(cacheMapper.mapFromEntityList(response))
            }
        }
    }
}
