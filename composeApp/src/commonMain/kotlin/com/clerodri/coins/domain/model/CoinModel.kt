package com.clerodri.coins.domain.model

import com.clerodri.core.domain.coin.Coin

data class CoinModel(
    val coin: Coin,
    val price: Double,
    val change: Double,
)
