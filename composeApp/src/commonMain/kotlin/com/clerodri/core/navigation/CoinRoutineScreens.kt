package com.clerodri.core.navigation
import kotlinx.serialization.Serializable
/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
@Serializable
object Portfolio

@Serializable
object Coins

@Serializable
data class  Buy(val coinId: String)

@Serializable
data class  Sell (val coinId: String)