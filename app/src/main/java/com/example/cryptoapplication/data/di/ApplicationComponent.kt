package com.example.cryptoapplication.data.di

import android.app.Application
import com.example.cryptoapplication.presentation.CoinDetailFragment
import com.example.cryptoapplication.presentation.CoinPriceListFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(coinPriceListFragment: CoinPriceListFragment)

    fun inject(coinDetailFragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}