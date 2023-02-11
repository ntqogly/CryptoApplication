package com.example.cryptoapplication.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo? = null
)
