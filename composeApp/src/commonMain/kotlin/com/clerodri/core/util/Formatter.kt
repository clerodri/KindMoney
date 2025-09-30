package com.clerodri.core.util

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/


expect fun formatFiat(amount: Double, showDecimal: Boolean = true): String

expect fun formatCoinUnit(amount: Double, symbol: String): String

expect fun formatPercentage(amount: Double): String