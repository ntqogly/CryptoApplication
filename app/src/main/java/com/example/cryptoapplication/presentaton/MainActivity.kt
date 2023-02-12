package com.example.cryptoapplication.presentaton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoapplication.R

class MainActivity : AppCompatActivity() {

    private val fragment = CoinPriceListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment).commit()
    }
}