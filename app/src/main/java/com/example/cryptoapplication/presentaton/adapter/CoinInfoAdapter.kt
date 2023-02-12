package com.example.cryptoapplication.presentaton.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapplication.R
import com.example.cryptoapplication.databinding.ItemCoinInfoBinding
import com.example.cryptoapplication.data.model.CoinPriceInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinInfoViewHolder(binding)
    }

    override fun getItemCount() = coinInfoList.size

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                with(binding) {
                    val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                    val lastUpdateTemplate =
                        context.resources.getString(R.string.last_update_template)
                    tvSymbols.text = String.format(symbolsTemplate, fromSymbol, toSymbol)
                    tvPrice.text = price
                    tvLastUpdate.text = String.format(lastUpdateTemplate, getFormattedTime())
                    Picasso.get().load(getFullImageUrl()).into(ivLogoCoin)
                    itemView.setOnClickListener {
                        onCoinClickListener?.onCoinClick(coin)
                    }
                }

            }
        }
    }

    class CoinInfoViewHolder(val binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo) {}
    }
}