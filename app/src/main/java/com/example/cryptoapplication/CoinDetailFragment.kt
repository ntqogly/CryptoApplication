package com.example.cryptoapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapplication.databinding.FragmentCoinDetailBinding
import com.squareup.picasso.Picasso

class CoinDetailFragment : Fragment() {

    private lateinit var viewModel: ViewModel

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding==null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!requireArguments().containsKey(EXTRA_FROM_SYMBOL)) {
            requireActivity().finish()
            return
        }
        val fromSymbol = requireArguments().getString(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        if (fromSymbol != null) {
            viewModel.getDetailInfo(fromSymbol).observe(viewLifecycleOwner) {
                with(binding) {
                    tvPrice.text = it.price
                    tvMinPrice.text = it.lowDay
                    tvMaxPrice.text = it.highDay
                    tvLastMarket.text = it.lastMarket
                    tvLastUpdate.text = it.getFormattedTime()
                    tvFromSymbol.text = it.fromSymbol
                    tvToSymbol.text = it.toSymbol
                    Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"

        fun newInstance(fromSymbol: String): CoinDetailFragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYMBOL, fromSymbol)
                }
            }
        }
    }
}