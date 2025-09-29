package com.clerodri.di

import com.clerodri.core.network.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { Android.create() }
    }