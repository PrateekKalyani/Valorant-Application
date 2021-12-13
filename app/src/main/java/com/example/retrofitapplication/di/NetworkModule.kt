package com.example.retrofitapplication.di

import android.content.Context
import com.example.retrofitapplication.R
import com.example.retrofitapplication.data.ValorantApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private var valorantApiService : ValorantApiService? = null

    @Provides
    fun getNewsApiService(@ApplicationContext context: Context) : ValorantApiService {

        if(valorantApiService == null) {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(context.getString(R.string.base_url))
                .build()

            valorantApiService = retrofit.create(ValorantApiService::class.java)
        }

        return valorantApiService!!
    }

}