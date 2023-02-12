package com.example.cryptoapplication.domain

class GetCoinInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.getCoinInfoList()
}

