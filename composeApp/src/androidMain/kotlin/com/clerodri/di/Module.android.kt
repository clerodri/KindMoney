package com.clerodri.di

import androidx.room.RoomDatabase
import com.clerodri.core.database.getPortfolioDatabaseBuilder
import com.clerodri.core.database.portfolio.PortfolioDatabase
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { Android.create() }

        singleOf(::getPortfolioDatabaseBuilder).bind<RoomDatabase.Builder<PortfolioDatabase>>()

    }