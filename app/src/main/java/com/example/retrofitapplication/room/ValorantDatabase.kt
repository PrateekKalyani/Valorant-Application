package com.example.retrofitapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ValorantEntity::class], version = 1)
@TypeConverters(ConverterHelper::class)
abstract class ValorantDatabase : RoomDatabase(){

    companion object {
        const val databaseName : String = "ValorantDatabase"
    }

    abstract fun valorantDao() : ValorantDao
}