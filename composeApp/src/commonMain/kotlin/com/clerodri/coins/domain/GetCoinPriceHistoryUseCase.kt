package com.clerodri.coins.domain

import com.clerodri.coins.data.mapper.toPriceModel
import com.clerodri.coins.domain.api.CoinsRemoteDataSource
import com.clerodri.coins.domain.model.PriceModel
import com.clerodri.core.domain.DataError
import com.clerodri.core.domain.Result
import com.clerodri.core.domain.map

data class GetCoinPriceHistoryUseCase(
    private val client: CoinsRemoteDataSource
){

    suspend operator fun invoke(coinId: String): Result<List<PriceModel>, DataError.Remote> {
        return client.getPriceHistory(coinId).map { dto ->
            dto.data.history.map { it.toPriceModel() }
        }
    }
}
