package com.ticonsys.cryptocomposeapp.data.remote

import com.ticonsys.cryptocomposeapp.data.remote.dto.CoinDetailDto
import com.ticonsys.cryptocomposeapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoinById(@Path("coin_id") coinId: String): CoinDetailDto

}