package com.example.cryptoapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapplication.data.network.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapplication.utils.convertTimestampToTime
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(
    @PrimaryKey
    val fromSymbol: String,
    val price: String?,
    val lowDay: String?,
    val highDay: String?,
    val lastMarket: String?,
    val toSymbol: String?,
    val lastUpdate: Long?,
    val imageUrl: String?
)