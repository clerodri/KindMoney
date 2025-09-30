package com.clerodri.trade.presentation.mapper

import com.clerodri.core.domain.coin.Coin
import com.clerodri.trade.presentation.common.UiTradeCoinItem

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
fun UiTradeCoinItem.toCoin() = Coin(
    id = id,
    name = name,
    symbol = symbol,
    iconUrl = iconUrl,
)