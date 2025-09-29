package com.clerodri.coins.domain.api

import com.clerodri.coins.data.remote.dto.CoinDetailsResponseDto
import com.clerodri.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.clerodri.coins.data.remote.dto.CoinsResponseDto
import com.clerodri.core.domain.DataError
import com.clerodri.core.domain.Result
/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
interface CoinsRemoteDataSource {

    suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote>

    suspend fun getPriceHistory( coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote>

    suspend fun getCoinById( coinId: String): Result<CoinDetailsResponseDto, DataError.Remote>
}