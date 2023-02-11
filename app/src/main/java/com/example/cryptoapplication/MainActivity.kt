package com.example.cryptoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapplication.api.ApiFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var coinViewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coinViewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        coinViewModel.loadData()
        coinViewModel.priceList.observe(this) {
            Log.d("TEST_OF_LOADING_DATA", "Success ACTIVITY $it")
        }
    }
}