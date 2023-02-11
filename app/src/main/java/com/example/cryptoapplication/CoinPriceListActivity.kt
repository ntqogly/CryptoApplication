package com.example.cryptoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var coinViewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        coinViewModel = ViewModelProvider(this)[CoinViewModel::class.java]
//        coinViewModel.priceList.observe(this) {
//            Log.d("TEST_OF_LOADING_DATA", "Success ACTIVITY $it")
//        }
        coinViewModel.getDetailInfo("ETH").observe(this){
            Log.d("TEST_OF_LOADING_DATA", "Success ACTIVITY $it")
        }
    }
}