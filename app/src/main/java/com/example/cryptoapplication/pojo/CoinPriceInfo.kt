package com.example.cryptoapplication.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinPriceInfo(
    @SerializedName("TYPE")
    @Expose
    private val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    private val market: String? = null,

    @SerializedName("FROMSYMBOL")
    @Expose
    private val fromSymbol: String? = null,

    @SerializedName("TOSYMBOL")
    @Expose
    private val toSymbol: String? = null,

    @SerializedName("FLAGS")
    @Expose
    private val flags: String? = null,

    @SerializedName("PRICE")
    @Expose
    private val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    private val lastUpdate: Int? = null,

    @SerializedName("MEDIAN")
    @Expose
    private val median: Double? = null,

    @SerializedName("LASTVOLUME")
    @Expose
    private val lastVolume: Double? = null,

    @SerializedName("LASTVOLUMETO")
    @Expose
    private val lastVolumeTo: Double? = null,

    @SerializedName("LASTTRADEID")
    @Expose
    private val lastTradeId: String? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    private val volumeDay: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    private val volumeDayTo: Double? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    private val volume24Hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    private val volume24HourTo: Double? = null,

    @SerializedName("OPENDAY")
    @Expose
    private val openDay: Double? = null
)