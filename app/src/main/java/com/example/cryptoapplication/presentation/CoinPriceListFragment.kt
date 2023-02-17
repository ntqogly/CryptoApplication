package com.example.cryptoapplication.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapplication.R
import com.example.cryptoapplication.presentation.adapter.CoinInfoAdapter
import com.example.cryptoapplication.databinding.FragmentCoinPriceListBinding
import com.example.cryptoapplication.domain.CoinInfo
import javax.inject.Inject

class CoinPriceListFragment : Fragment() {
    private lateinit var coinViewModel: CoinViewModel
    private lateinit var rvCoinPriceList: RecyclerView
    private lateinit var binding: FragmentCoinPriceListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as CoinApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinPriceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCoinPriceList = binding.rvCoinPriceList
        binding.rvCoinPriceList.itemAnimator = null
        val coinInfoAdapter = CoinInfoAdapter(requireContext())
        rvCoinPriceList.adapter = coinInfoAdapter
        coinViewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
        coinViewModel.coinInfoList.observe(viewLifecycleOwner) {
            coinInfoAdapter.submitList(it)
        }

        coinInfoAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinInfo) {
                requireActivity().supportFragmentManager.beginTransaction().replace(
                    R.id.container, CoinDetailFragment.newInstance(coinPriceInfo.fromSymbol)
                ).addToBackStack(null).commit()
            }
        }
    }
}