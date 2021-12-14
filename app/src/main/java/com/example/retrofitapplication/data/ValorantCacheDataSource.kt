package com.example.retrofitapplication.data

import com.example.retrofitapplication.room.ValorantDao
import com.example.retrofitapplication.room.ValorantEntity
import javax.inject.Inject

interface ValorantCacheDataSource {

    suspend fun getAgents() : List<ValorantEntity>

    suspend fun saveAgents(agentList : List<ValorantEntity>)
}

class ValorantCacheDataSourceImpl
@Inject
constructor(
    private val valorantDao: ValorantDao
    ): ValorantCacheDataSource {

    override suspend fun getAgents(): List<ValorantEntity> {
        return valorantDao.getAgents()
    }

    override suspend fun saveAgents(agentList: List<ValorantEntity>) {

        if(agentList.isEmpty())
            return
        valorantDao.insertAgents(productList = agentList)
    }
}