package com.ticonsys.cryptocomposeapp.presentation.coin.detail


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticonsys.cryptocomposeapp.domain.usecases.coin.detail.GetCoinUseCase
import com.ticonsys.cryptocomposeapp.internal.Constant
import com.ticonsys.cryptocomposeapp.internal.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCoinUseCase: GetCoinUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state


    init {
        savedStateHandle.get<String>(Constant.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }


    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> _state.value =
                    CoinDetailState(error = result.message ?: "An unexpected error occurred")
                is Resource.Loading -> _state.value = CoinDetailState(isLoading = true)
                is Resource.Success -> _state.value =
                    CoinDetailState(coin = result.data)
            }
        }.launchIn(viewModelScope)
    }

}