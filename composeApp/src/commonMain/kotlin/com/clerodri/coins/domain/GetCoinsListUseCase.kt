package com.clerodri.coins.domain

import com.clerodri.coins.data.mapper.toCoinModel
import com.clerodri.coins.domain.api.CoinsRemoteDataSource
import com.clerodri.coins.domain.model.CoinModel
import com.clerodri.core.domain.DataError
import com.clerodri.core.domain.Result
import com.clerodri.core.domain.map

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
class GetCoinsListUseCase(
    private val client: CoinsRemoteDataSource
){
    suspend operator fun invoke(): Result<List<CoinModel>, DataError.Remote> {
        return client.getListOfCoins().map { dto ->
            dto.data.coins.map { it.toCoinModel() }
        }
    }
}