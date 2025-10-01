package com.clerodri.trade.presentation.buy

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import com.clerodri.trade.presentation.common.TradeScreen
import com.clerodri.trade.presentation.common.TradeState
import com.clerodri.trade.presentation.common.TradeType
import com.clerodri.trade.presentation.common.UiTradeCoinItem
import kindmoney.composeapp.generated.resources.Res
import kindmoney.composeapp.generated.resources.error_unknown
import kotlin.test.Test

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
class BuyScreenTest {
    @OptIn( ExperimentalTestApi::class)
    @Test
    fun checkSubmitButtonLabelChangesWithTradeType() = runComposeUiTest {
        val state = TradeState(
            coin = UiTradeCoinItem(
                id = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                iconUrl = "url",
                price = 50000.0
            )
        )

        setContent {
            TradeScreen(
                state = state,
                tradeType = TradeType.BUY,
                onAmountChange = {},
                onSubmitClicked = {}
            )
        }

        onNodeWithText("Sell Now").assertDoesNotExist()
        onNodeWithText("Buy Now").assertExists()
        onNodeWithText("Buy Now").assertIsDisplayed()

        setContent {
            TradeScreen(
                state = state,
                tradeType = TradeType.SELL,
                onAmountChange = {},
                onSubmitClicked = {}
            )
        }

        onNodeWithText("Buy Now").assertDoesNotExist()
        onNodeWithText("Sell Now").assertExists()
        onNodeWithText("Sell Now").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun checkIfCoinNameShowProperlyInBuy() = runComposeUiTest {
        val state = TradeState(
            coin = UiTradeCoinItem(
                id = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                iconUrl = "url",
                price = 50000.0
            )
        )

        setContent {
            TradeScreen(
                state = state,
                tradeType = TradeType.BUY,
                onAmountChange = {},
                onSubmitClicked = {}
            )
        }

        onNodeWithTag("trade_screen_coin_name").assertExists()
        onNodeWithTag("trade_screen_coin_name").assertTextEquals("Bitcoin")
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun checkErrorIsShownProperly() = runComposeUiTest {
        val state = TradeState(
            coin = UiTradeCoinItem(
                id = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                iconUrl = "url",
                price = 50000.0
            ),
            error = Res.string.error_unknown
        )

        setContent {
            TradeScreen(
                state = state,
                tradeType = TradeType.BUY,
                onAmountChange = {},
                onSubmitClicked = {}
            )
        }

        onNodeWithTag("trade_error").assertExists()
        onNodeWithTag("trade_error").assertIsDisplayed()
    }
}