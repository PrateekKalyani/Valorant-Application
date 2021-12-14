package com.example.retrofitapplication.data

import com.example.retrofitapplication.room.ValorantDao
import com.example.retrofitapplication.room.ValorantAgentEntity
import javax.inject.Inject

interface ValorantCacheDataSource {

    suspend fun getAgents() : List<ValorantAgentEntity>

    suspend fun saveAgents(agentList : List<ValorantAgentEntity>)
}

class ValorantCacheDataSourceImpl
@Inject
constructor(
    private val valorantDao: ValorantDao
    ): ValorantCacheDataSource {

    override suspend fun getAgents(): List<ValorantAgentEntity> {
        return valorantDao.getAgents()
    }

    override suspend fun saveAgents(agentList: List<ValorantAgentEntity>) {

        if(agentList.isEmpty())
            return
        valorantDao.insertAgents(productList = agentList)
    }
}