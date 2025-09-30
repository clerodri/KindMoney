package com.clerodri.coins.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clerodri.coins.domain.GetCoinPriceHistoryUseCase
import com.clerodri.coins.domain.GetCoinsListUseCase
import com.clerodri.core.domain.Result
import com.clerodri.core.util.formatFiat
import com.clerodri.core.util.formatPercentage
import com.clerodri.core.util.toUiText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
class CoinsListViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase,
    private val getCoinPriceHistoryUseCase: GetCoinPriceHistoryUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CoinsState())
    val state = _state
        .onStart {
            getAllCoins()
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CoinsState()
        )


    private suspend fun getAllCoins(){
        when( val coinsResponse  = getCoinsListUseCase()){
            is Result.Error -> {
                _state.update {
                    it.copy(
                        coins = emptyList(),
                        error = coinsResponse.error.toUiText()
                    )
                }
            }
            is Result.Success -> {
                _state.update {
                    CoinsState(
                        coins = coinsResponse.data.map {  coinItem ->
                            UiCoinListItem(
                                id = coinItem.coin.id,
                                name = coinItem.coin.name,
                                symbol = coinItem.coin.symbol,
                                iconUrl = coinItem.coin.iconUrl,
                                formattedPrice = formatFiat(coinItem.price),
                                formattedChange = formatPercentage(coinItem.change) ,
                                isPositive = coinItem.change >= 0,
                            )
                        }
                    )
                }
            }
        }
    }

    fun onCoinLongPressed( coinId: String){
        _state.update {
            it.copy(
                chartState = UiChartState(
                    sparkLine = emptyList(),
                    isLoading = true,
                )
            )
        }

        viewModelScope.launch {
            when ( val priceHistory = getCoinPriceHistoryUseCase(coinId)) {

                is Result.Success -> {
                    _state.update { currentState ->
                        currentState.copy(
                            chartState = UiChartState(
                                sparkLine =  priceHistory.data.sortedBy { it.timestamp }.map { it.price},
                                isLoading = false,
                                coinName = _state.value.coins.find { it.id == coinId }?.name.orEmpty(),
                            )
                        )
                    }
                }
                is Result.Error -> {
                    _state.update {
                        it.copy( chartState = UiChartState(
                            sparkLine = emptyList(),
                            isLoading = false,
                            coinName = "")
                        )
                    }
                }
            }
        }
    }

    fun onDismissChart(){
        _state.update {
            it.copy( chartState = null )
        }
    }
}