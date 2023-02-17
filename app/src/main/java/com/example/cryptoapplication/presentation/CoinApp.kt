package com.example.cryptoapplication.presentation

import android.app.Application
import com.example.cryptoapplication.data.di.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}