package com.clerodri


import androidx.compose.runtime.*
import com.clerodri.coins.presentation.CoinsListScreen
import com.clerodri.portfolio.presentation.PortfolioScreen
import com.clerodri.theme.CoinRoutineTheme
import org.jetbrains.compose.ui.tooling.preview.Preview



@Composable
@Preview
fun App() {
    CoinRoutineTheme {
       // CoinsListScreen {  }
        PortfolioScreen(
            onCoinItemClicked = {},
            onDiscoverCoinsClicked = {}
        )

    }
}