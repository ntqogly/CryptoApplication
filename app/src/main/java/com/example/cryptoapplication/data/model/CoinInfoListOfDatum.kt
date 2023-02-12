package com.example.cryptoapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoListOfDatum (
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)