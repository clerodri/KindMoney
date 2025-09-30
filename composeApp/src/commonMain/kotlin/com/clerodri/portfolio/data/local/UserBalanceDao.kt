package com.clerodri.porfolio.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
@Dao
interface UserBalanceDao {

    @Query("SELECT cashBalance FROM UserBalanceEntity WHERE id = 1")
    suspend fun getCashBalance(): Double?

    @Upsert
    suspend fun insertBalance(userBalanceEntity: UserBalanceEntity)

    @Query("UPDATE UserBalanceEntity SET cashBalance = :newBalance WHERE id = 1")
    suspend fun updateCashBalance(newBalance: Double)
}