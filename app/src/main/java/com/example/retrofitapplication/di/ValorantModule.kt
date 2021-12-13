package com.example.retrofitapplication.di

import android.content.Context
import com.example.retrofitapplication.data.*
import com.example.retrofitapplication.domain.ValorantUseCase
import com.example.retrofitapplication.mapper.CacheMapper
import com.example.retrofitapplication.room.ValorantDao
import com.example.retrofitapplication.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ValorantModule {

    @Provides
    fun getUtil(
        @ApplicationContext context: Context
    ) : Util {

        return Util(
            context = context
        )
    }
    @Provides
    fun getCacheMapper() : CacheMapper {
        return CacheMapper()
    }


    @Provides
    fun getValorantRemoteDataSource(
        valorantApiService: ValorantApiService
    ) : ValorantRemoteDataSource {

        return ValorantRemoteDataSourceImpl(
            valorantApiService = valorantApiService
        )
    }

    @Provides
    fun getValorantCacheDataSource(
        valorantDao: ValorantDao
    ) : ValorantCacheDataSource {
        return ValorantCacheDataSourceImpl(
            valorantDao = valorantDao
        )
    }

    @Provides
    fun getValorantRepository(
        valorantRemoteDataSource: ValorantRemoteDataSource,
        valorantCacheDataSource: ValorantCacheDataSource,
        chacheMapper: CacheMapper
    ) : ValorantRepository {

        return ValorantRepositoryImpl(
            valorantRemoteDataSource = valorantRemoteDataSource,
            valorantCacheDataSource = valorantCacheDataSource,
            cacheMapper = chacheMapper
        )
    }

    @Provides
    fun getValorantUseCase(
        valorantRepository: ValorantRepository,
        util: Util
    ): ValorantUseCase {

        return ValorantUseCase(
            valorantRepository = valorantRepository,
            util = util
        )
    }
}