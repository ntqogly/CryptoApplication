package com.example.cryptoapplication.data.di

import com.example.cryptoapplication.data.workers.ChildWorkerFactory
import com.example.cryptoapplication.data.workers.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(refreshDataWorker: RefreshDataWorker.Factory): ChildWorkerFactory
}