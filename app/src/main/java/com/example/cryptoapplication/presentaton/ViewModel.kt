package com.example.cryptoapplication.presentaton

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptoapplication.data.network.model.CoinInfoDto
import com.example.cryptoapplication.data.repository.CoinRepositoryImpl
import com.example.cryptoapplication.domain.GetCoinInfoListUseCase
import com.example.cryptoapplication.domain.GetCoinInfoUseCase
import com.example.cryptoapplication.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}