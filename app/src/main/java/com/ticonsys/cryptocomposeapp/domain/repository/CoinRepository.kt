package com.ticonsys.cryptocomposeapp.domain.repository

import com.ticonsys.cryptocomposeapp.data.remote.dto.CoinDetailDto
import com.ticonsys.cryptocomposeapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}