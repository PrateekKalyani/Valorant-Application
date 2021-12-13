package com.example.retrofitapplication.data

import com.example.retrofitapplication.room.ValorantDao
import com.example.retrofitapplication.room.ValorantEntity
import javax.inject.Inject

interface ValorantCacheDataSource {

    suspend fun getAgents() : List<ValorantEntity>

    suspend fun saveAgents(agentsList : List<ValorantEntity>)
}

class ValorantCacheDataSourceImpl
@Inject
constructor(
    private val valorantDao: ValorantDao
    ): ValorantCacheDataSource {

    override suspend fun getAgents(): List<ValorantEntity> {
        return valorantDao.getAgents()
    }

    override suspend fun saveAgents(agentsList: List<ValorantEntity>) {

        if(agentsList.isEmpty())
            return
        valorantDao.insertAgents(agentsList)
    }
}