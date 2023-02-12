package com.example.cryptoapplication.presentaton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapplication.R
import com.example.cryptoapplication.presentaton.adapter.CoinInfoAdapter
import com.example.cryptoapplication.databinding.FragmentCoinPriceListBinding
import com.example.cryptoapplication.data.model.CoinPriceInfo

class CoinPriceListFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    private lateinit var rvCoinPriceList: RecyclerView
    private lateinit var binding: FragmentCoinPriceListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinPriceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCoinPriceList = binding.rvCoinPriceList
        val coinInfoAdapter = CoinInfoAdapter(requireContext())
        rvCoinPriceList.adapter = coinInfoAdapter
        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.priceList.observe(viewLifecycleOwner) {
            coinInfoAdapter.coinInfoList = it
        }

        coinInfoAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        CoinDetailFragment.newInstance(coinPriceInfo.fromSymbol)
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}