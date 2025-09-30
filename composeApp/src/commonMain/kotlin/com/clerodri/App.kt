package com.clerodri


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clerodri.coins.presentation.CoinsListScreen
import com.clerodri.core.navigation.Buy
import com.clerodri.core.navigation.Coins
import com.clerodri.core.navigation.Portfolio
import com.clerodri.core.navigation.Sell
import com.clerodri.portfolio.presentation.PortfolioScreen
import com.clerodri.theme.CoinRoutineTheme
import com.clerodri.trade.presentation.buy.BuyScreen
import com.clerodri.trade.presentation.sell.SellScreen
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val navController: NavHostController = rememberNavController()
    CoinRoutineTheme {
        NavHost(
            navController = navController,
            startDestination = Portfolio,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<Portfolio>{
                PortfolioScreen(
                    onCoinItemClicked = {coinId ->
                        navController.navigate(Sell)

                    },
                    onDiscoverCoinsClicked = {
                        navController.navigate(Coins)
                    },
                )
            }


            composable<Coins>{
                CoinsListScreen(
                    onCoinClicked = {coinId ->
                        navController.navigate(Buy)
                    }
                )
            }

            composable<Buy> { navBackStackEntry ->
                //val coinId: String = navBackStackEntry.toRoute<Buy>().coinId
                BuyScreen(
                    coinId = "todo",
                    navigateToPortfolio = {
                        navController.navigate(Portfolio) {
                            popUpTo(Portfolio) { inclusive = true }
                        }
                    }
                )
            }
            composable<Sell> { navBackStackEntry ->
                //val coinId: String = navBackStackEntry.toRoute<Sell>().coinId
                SellScreen(
                    coinId = "todo",
                    navigateToPortfolio = {
                        navController.navigate(Portfolio) {
                            popUpTo(Portfolio) { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}