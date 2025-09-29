package com.clerodri.coins.domain

import com.clerodri.coins.data.mapper.toCoinModel
import com.clerodri.coins.domain.api.CoinsRemoteDataSource
import com.clerodri.coins.domain.model.CoinModel
import com.clerodri.core.domain.DataError
import com.clerodri.core.domain.map
import com.clerodri.core.domain.Result
data class GetCoinDetailsUseCase(
    private val client: CoinsRemoteDataSource
){

    suspend operator fun invoke(id: String): Result<CoinModel, DataError.Remote> {
        return client.getCoinById(id).map { dto ->
            dto.data.coin.toCoinModel()
        }
    }
}
