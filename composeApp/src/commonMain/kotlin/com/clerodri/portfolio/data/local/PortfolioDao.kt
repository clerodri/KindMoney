package com.clerodri.porfolio.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
@Dao
interface PortfolioDao {

    @Upsert
    suspend fun insert(portfolioCoinEntity: PortfolioCoinEntity)

    @Query("SELECT * FROM PortfolioCoinEntity ORDER BY timestamp DESC")
    fun getAllOwnedCoins(): Flow<List<PortfolioCoinEntity>>

    @Query("SELECT * FROM PortfolioCoinEntity WHERE coinId = :coinId")
    suspend fun getCoinById(coinId: String): PortfolioCoinEntity?

    @Query("DELETE FROM PortfolioCoinEntity WHERE coinId = :coinId")
    suspend fun deletePortfolioItem(coinId: String)
}