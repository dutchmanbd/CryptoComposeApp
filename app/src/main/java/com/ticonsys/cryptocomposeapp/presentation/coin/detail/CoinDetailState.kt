package com.ticonsys.cryptocomposeapp.presentation.coin.detail

import com.ticonsys.cryptocomposeapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)