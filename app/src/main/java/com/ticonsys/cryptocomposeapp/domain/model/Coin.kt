package com.ticonsys.cryptocomposeapp.domain.model

import com.ticonsys.cryptocomposeapp.data.remote.dto.CoinDto


data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)

