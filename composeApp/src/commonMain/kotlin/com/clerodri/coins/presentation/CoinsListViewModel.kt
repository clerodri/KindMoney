package com.clerodri.coins.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clerodri.coins.domain.GetCoinsListUseCase
import com.clerodri.core.domain.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
class CoinsListViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase
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
                        error = null //TODO coinsResponse.error.toUiText()
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
                                formattedPrice = coinItem.price.toString(), //TODO formatFiat(coinItem.price)
                                formattedChange = coinItem.change.toString() , //TODO formatPercentage(coinItem.change)
                                isPositive = coinItem.change >= 0,
                            )
                        }
                    )
                }
            }
        }
    }
}