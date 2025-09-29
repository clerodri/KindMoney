package com.clerodri.coins.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.clerodri.theme.LocalCoinRoutineColorsPalette
import org.koin.compose.viewmodel.koinViewModel

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
@Composable
fun CoinsListScreen(
    onCoinClick: (String) -> Unit
) {
    val coinsListViewModel = koinViewModel<CoinsListViewModel>()
    val state by coinsListViewModel.state.collectAsStateWithLifecycle()
    CoinsListContent(
        state = state,
        onCoinClick = onCoinClick
    )
}

@Composable
fun CoinsListContent(
    state: CoinsState,
    onCoinClick: (String) -> Unit,
) {
    Box( modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ){
        CoinsList(
            coins = state.coins,
            onCoinClick = onCoinClick
        )
    }
}

@Composable
fun CoinsList(
    coins: List<UiCoinListItem>,
    onCoinClick: (String) -> Unit )
{
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "Top Coins: ",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    modifier = Modifier.padding(16.dp)
                )
            }
            items(coins){ coin ->
                CoinListItem(
                    coin = coin,
                    onCoinClick = onCoinClick
                )
            }
        }
    }
}

@Composable
fun CoinListItem(coin: UiCoinListItem, onCoinClick: (String) -> Unit) {
    Row( verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .clickable { onCoinClick(coin.id) }
            .padding(16.dp)
    ){
        AsyncImage(
            model = coin.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(4.dp).clip(CircleShape).size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = coin.name,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = coin.symbol,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            horizontalAlignment = Alignment.End,
        ){
            Text(
                text = coin.formattedPrice,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = coin.formattedChange,
                color = if (coin.isPositive) LocalCoinRoutineColorsPalette.current.profitGreen
                        else LocalCoinRoutineColorsPalette.current.lossRed,
                fontSize = MaterialTheme.typography.titleSmall.fontSize
            )
        }
    }
}