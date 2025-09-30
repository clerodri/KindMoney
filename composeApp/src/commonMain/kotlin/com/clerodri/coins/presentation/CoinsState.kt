package com.clerodri.coins.presentation

import androidx.compose.runtime.Stable
import org.jetbrains.compose.resources.StringResource

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
@Stable
data class CoinsState(
    val error: StringResource ? = null,
    val coins: List<UiCoinListItem> = emptyList(),
    val chartState: UiChartState? = null
)

@Stable
data class UiChartState(
    val sparkLine: List<Double> = emptyList(),
    val isLoading: Boolean = false,
    val coinName: String = ""
)