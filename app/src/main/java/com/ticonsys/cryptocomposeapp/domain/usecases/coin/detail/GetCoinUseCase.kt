package com.ticonsys.cryptocomposeapp.domain.usecases.coin.detail

import com.ticonsys.cryptocomposeapp.data.remote.dto.toCoinDetail
import com.ticonsys.cryptocomposeapp.domain.model.CoinDetail
import com.ticonsys.cryptocomposeapp.domain.repository.CoinRepository
import com.ticonsys.cryptocomposeapp.internal.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }

}