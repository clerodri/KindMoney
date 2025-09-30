package com.clerodri.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.clerodri.core.database.portfolio.PortfolioDatabase
import platform.Foundation.NSHomeDirectory

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
fun getPortfolioDatabaseBuilder(): RoomDatabase.Builder<PortfolioDatabase> {
    val dbFile = NSHomeDirectory() + "/portfolio.db"
    return Room.databaseBuilder<PortfolioDatabase>(
        name = dbFile,
    )
}