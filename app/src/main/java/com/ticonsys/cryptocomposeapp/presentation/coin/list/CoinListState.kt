package com.ticonsys.cryptocomposeapp.presentation.coin.list

import com.ticonsys.cryptocomposeapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)