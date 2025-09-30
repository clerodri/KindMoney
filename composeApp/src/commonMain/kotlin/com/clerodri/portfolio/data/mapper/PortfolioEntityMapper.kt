package com.clerodri.portfolio.data.mapper

import com.clerodri.core.domain.coin.Coin
import com.clerodri.porfolio.data.local.PortfolioCoinEntity
import com.clerodri.porfolio.domain.PortfolioCoinModel
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
fun PortfolioCoinEntity.toPortfolioCoinModel(
    currentPrice: Double,
): PortfolioCoinModel {
    return PortfolioCoinModel(
        coin = Coin(
            id = coinId,
            name = name,
            symbol = symbol,
            iconUrl = iconUrl
        ),
        performancePercent = ((currentPrice - averagePurchasePrice) / averagePurchasePrice) * 100,
        averagePurchasePrice = averagePurchasePrice,
        ownedAmountInUnit = amountOwned,
        ownedAmountInFiat = amountOwned * currentPrice,
    )
}

@OptIn(ExperimentalTime::class)
fun PortfolioCoinModel.toPortfolioCoinEntity(): PortfolioCoinEntity {
    return PortfolioCoinEntity(
        coinId = coin.id,
        name = coin.name,
        symbol = coin.symbol,
        iconUrl = coin.iconUrl,
        amountOwned = ownedAmountInUnit,
        averagePurchasePrice = averagePurchasePrice,
        timestamp = Clock.System.now().toEpochMilliseconds()
    )
}