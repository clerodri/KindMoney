package com.clerodri.coins.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
@Serializable
data class CoinDetailsResponseDto(
    val data: CoinResponseDto,
)

@Serializable
data class CoinResponseDto(
    val coin: CoinItemDto
)