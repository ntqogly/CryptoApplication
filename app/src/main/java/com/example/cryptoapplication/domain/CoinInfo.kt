package com.example.cryptoapplication.domain

data class CoinInfo(
    val fromSymbol: String,
    val price: String?,
    val lowDay: String?,
    val highDay: String?,
    val lastMarket: String?,
    val toSymbol: String?,
    val lastUpdate: Long?,
    val imageUrl: String?

)
