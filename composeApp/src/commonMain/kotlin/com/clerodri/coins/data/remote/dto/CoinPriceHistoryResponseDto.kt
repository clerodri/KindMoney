package com.clerodri.coins.data.remote.dto
import kotlinx.serialization.Serializable
/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
@Serializable
data class CoinPriceHistoryResponseDto(
    val data: CoinPriceHistoryDto,
)

@Serializable
data class CoinPriceHistoryDto(
    val history: List<CoinPriceDto>
)
@Serializable
data class CoinPriceDto(
    val date: String,
    val price: Double,
    val timestamp: Long
)