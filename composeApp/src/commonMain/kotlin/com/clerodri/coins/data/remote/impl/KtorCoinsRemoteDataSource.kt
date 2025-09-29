package com.clerodri.coins.data.remote.impl

import com.clerodri.coins.data.remote.dto.CoinDetailsResponseDto
import com.clerodri.coins.data.remote.dto.CoinPriceHistoryResponseDto
import com.clerodri.coins.data.remote.dto.CoinsResponseDto
import com.clerodri.coins.domain.api.CoinsRemoteDataSource
import com.clerodri.core.domain.DataError
import com.clerodri.core.domain.Result
import com.clerodri.core.network.safeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
private const val BASE_URL = "https://api.coinranking.com/v2"

class KtorCoinsRemoteDataSource (
    private val httpClient: HttpClient
): CoinsRemoteDataSource{


    override suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coins")
        }
    }

    override suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId/history")
        }
    }

    override suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote> {
        return  safeCall {
            httpClient.get("$BASE_URL/coin/$coinId")
        }
    }
}