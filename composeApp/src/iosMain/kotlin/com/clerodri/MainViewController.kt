package com.clerodri

import androidx.compose.ui.window.ComposeUIViewController
import com.clerodri.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }