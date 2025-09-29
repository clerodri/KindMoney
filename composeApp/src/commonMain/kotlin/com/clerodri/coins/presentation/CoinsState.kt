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
)