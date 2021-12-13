package com.example.retrofitapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ValorantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAgents(productList : List<ValorantEntity>)

    @Query("SELECT * FROM ValorantTable")
    suspend fun getAgents() : List<ValorantEntity>
}