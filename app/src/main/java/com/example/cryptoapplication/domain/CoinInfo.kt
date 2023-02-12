package com.example.cryptoapplication.domain

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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
