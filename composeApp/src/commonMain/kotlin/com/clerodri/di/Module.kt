package com.clerodri.di


import com.clerodri.coins.data.remote.impl.KtorCoinsRemoteDataSource
import com.clerodri.coins.domain.GetCoinDetailsUseCase
import com.clerodri.coins.domain.GetCoinsListUseCase
import com.clerodri.coins.domain.api.CoinsRemoteDataSource
import com.clerodri.coins.presentation.CoinsListViewModel
import com.clerodri.core.network.HttpClientFactory
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


    //viewmodel
    viewModel { CoinsListViewModel(get()) }
    singleOf(::GetCoinsListUseCase)  // FOR USECASE THAT VIEWMODEL NEEDS

    singleOf(::KtorCoinsRemoteDataSource).bind<CoinsRemoteDataSource>()
    singleOf(::GetCoinDetailsUseCase)
}