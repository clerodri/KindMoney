package com.clerodri.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clerodri.core.database.portfolio.PortfolioDatabase

/**
 * Author: Ronaldo R.
 * Date:  9/30/2025
 * Description:
 **/
fun getPortfolioDatabaseBuilder(context: Context): RoomDatabase.Builder<PortfolioDatabase> {
    val dbFile = context.getDatabasePath("portfolio.db")
    return Room.databaseBuilder<PortfolioDatabase>(
        context = context,
        name = dbFile.absolutePath,
    )
}