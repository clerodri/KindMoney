package com.clerodri.coins.data.mapper

import com.clerodri.coins.data.remote.dto.CoinItemDto
import com.clerodri.coins.data.remote.dto.CoinPriceDto
import com.clerodri.coins.domain.model.CoinModel
import com.clerodri.coins.domain.model.PriceModel
import com.clerodri.core.domain.coin.Coin

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
fun CoinItemDto.toCoinModel() = CoinModel(
    coin = Coin(
        id = uuid,
        name = name,
        symbol = symbol,
        iconUrl = iconUrl,
        ),
    price = price,
    change = change
)


fun CoinPriceDto.toPriceModel() = PriceModel(
    price = price ?: 0.0,
    timestamp = timestamp
)