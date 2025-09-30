package com.clerodri.core.database.portfolio

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.clerodri.core.database.porfolio.PortfolioDatabaseCreator
import com.clerodri.porfolio.data.local.PortfolioCoinEntity
import com.clerodri.porfolio.data.local.PortfolioDao
import com.clerodri.porfolio.data.local.UserBalanceDao
import com.clerodri.porfolio.data.local.UserBalanceEntity

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
@ConstructedBy(PortfolioDatabaseCreator::class)
@Database(entities = [PortfolioCoinEntity::class, UserBalanceEntity::class], version = 1)
abstract class PortfolioDatabase: RoomDatabase() {
    abstract fun portfolioDao(): PortfolioDao
    abstract fun userBalanceDao(): UserBalanceDao
}