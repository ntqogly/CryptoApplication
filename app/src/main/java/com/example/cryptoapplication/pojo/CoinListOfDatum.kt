package com.example.cryptoapplication.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinInfoListOfDatum(
    @SerializedName("Data")
    @Expose
    val data: List<Datum>? = null
)