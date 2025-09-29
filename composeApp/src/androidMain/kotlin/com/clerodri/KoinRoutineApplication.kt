package com.clerodri

import android.app.Application
import com.clerodri.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

/**
 * Author: Ronaldo R.
 * Date:  9/29/2025
 * Description:
 **/
class KoinRoutineApplication: Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@KoinRoutineApplication)
        }
    }
}