package com.clerodri.coins.data.remote.dto
import kotlinx.serialization.Serializable

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
@Serializable
data class CoinsResponseDto(
    val data: CoinsListDto
)

@Serializable
data class CoinsListDto(
    val coins: List<CoinItemDto>
)

@Serializable
data class  CoinItemDto(
    val uuid: String,
    val symbol: String,
    val name: String,
    val iconUrl: String,
    val price: Double,
    val rank: Int,
    val change: Double
)