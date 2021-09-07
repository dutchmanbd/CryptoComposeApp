package com.ticonsys.cryptocomposeapp.data.repository

import com.ticonsys.cryptocomposeapp.data.remote.CoinPaprikaApiService
import com.ticonsys.cryptocomposeapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CoinPaprikaApiService
) : CoinRepository {
    override suspend fun getCoins() = apiService.getCoins()

    override suspend fun getCoinById(coinId: String) = apiService.getCoinById(coinId)


}