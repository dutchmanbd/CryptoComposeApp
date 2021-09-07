package com.ticonsys.cryptocomposeapp.di

import com.ticonsys.cryptocomposeapp.data.remote.CoinPaprikaApiService
import com.ticonsys.cryptocomposeapp.data.repository.CoinRepositoryImpl
import com.ticonsys.cryptocomposeapp.domain.repository.CoinRepository
import com.ticonsys.cryptocomposeapp.internal.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApiService(): CoinPaprikaApiService {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(
        apiService: CoinPaprikaApiService
    ): CoinRepository = CoinRepositoryImpl(apiService = apiService)




}