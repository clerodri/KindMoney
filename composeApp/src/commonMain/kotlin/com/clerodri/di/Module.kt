package com.clerodri.di


import androidx.room.RoomDatabase
import com.clerodri.coins.data.remote.impl.KtorCoinsRemoteDataSource
import com.clerodri.coins.domain.GetCoinDetailsUseCase
import com.clerodri.coins.domain.GetCoinPriceHistoryUseCase
import com.clerodri.coins.domain.GetCoinsListUseCase
import com.clerodri.coins.domain.api.CoinsRemoteDataSource
import com.clerodri.coins.presentation.CoinsListViewModel
import com.clerodri.core.database.porfolio.getPortfolioDatabase
import com.clerodri.core.database.portfolio.PortfolioDatabase
import com.clerodri.core.network.HttpClientFactory
import com.clerodri.porfolio.domain.PortfolioRepository
import com.clerodri.portfolio.data.PortfolioRepositoryImpl
import com.clerodri.portfolio.presentation.PortfolioViewModel
import com.clerodri.trade.domain.BuyCoinUseCase
import io.ktor.client.HttpClient
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            sharedModules ,
            platformModule,
        )
    }

expect val platformModule: Module

val sharedModules = module{

    //core
    single<HttpClient> { HttpClientFactory.create(get()) }

    //portfolio
    single {
        getPortfolioDatabase(get<RoomDatabase.Builder<PortfolioDatabase>>())
    }
    singleOf(::PortfolioRepositoryImpl).bind<PortfolioRepository>()
    single { get<PortfolioDatabase>().portfolioDao() }
    single { get<PortfolioDatabase>().userBalanceDao() }
    viewModel { PortfolioViewModel(get()) }
    singleOf(::BuyCoinUseCase)
    //coins list
    viewModel { CoinsListViewModel(get(), get()) }
    singleOf(::GetCoinsListUseCase)  // FOR USECASE THAT VIEWMODEL NEEDS
    singleOf(::KtorCoinsRemoteDataSource).bind<CoinsRemoteDataSource>()
    singleOf(::GetCoinDetailsUseCase)
    singleOf(::GetCoinPriceHistoryUseCase)
}