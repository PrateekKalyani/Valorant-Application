package com.example.retrofitapplication.di

import android.content.Context
import androidx.room.Room
import com.example.retrofitapplication.room.ValorantDao
import com.example.retrofitapplication.room.ValorantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomClient {

    private var databaseBuilder : ValorantDao? = null

    @Provides
    fun provideValorantDao(
        @ApplicationContext context : Context
    ) : ValorantDao {

        if(databaseBuilder == null) {
            databaseBuilder = Room.databaseBuilder(
                context,
                ValorantDatabase::class.java,
                ValorantDatabase.databaseName
                ).build().valorantDao()
        }
        return databaseBuilder!!
    }
}