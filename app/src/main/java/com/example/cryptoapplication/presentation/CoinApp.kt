package com.example.cryptoapplication.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapplication.data.database.AppDatabase
import com.example.cryptoapplication.data.di.DaggerApplicationComponent
import com.example.cryptoapplication.data.network.ApiFactory
import com.example.cryptoapplication.data.workers.RefreshDataWorkerFactory

class CoinApp : Application(), Configuration.Provider {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(
            RefreshDataWorkerFactory(
                AppDatabase.getInstance(this).coinPriceInfoDao(),
                ApiFactory.apiService,
                com.example.cryptoapplication.data.mapper.CoinMapper()
            )
        ).build()
    }
}