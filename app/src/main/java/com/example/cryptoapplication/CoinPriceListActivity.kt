package com.example.cryptoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapplication.adapter.CoinInfoAdapter
import com.example.cryptoapplication.pojo.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var rvCoinPriceList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        rvCoinPriceList = findViewById(R.id.rvCoinPriceList)
        val coinInfoAdapter = CoinInfoAdapter(this)
        coinInfoAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }

        rvCoinPriceList.adapter = coinInfoAdapter
        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.priceList.observe(this) {
            coinInfoAdapter.coinInfoList = it
        }
    }
}