package com.example.cryptoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapplication.adapter.CoinInfoAdapter
import com.example.cryptoapplication.pojo.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {


    private lateinit var coinViewModel: CoinViewModel
    private lateinit var rvCoinPriceList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        rvCoinPriceList = findViewById(R.id.rvCoinPriceList)
        val coinInfoAdapter = CoinInfoAdapter(this)
        coinInfoAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                Log.d("TEST", coinPriceInfo.fromSymbol)
            }
        }

        rvCoinPriceList.adapter = coinInfoAdapter
        coinViewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        coinViewModel.priceList.observe(this) {
            coinInfoAdapter.coinInfoList = it
        }
    }
}