package com.example.hackhaton.ui.pager.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackhaton.databinding.FragmentEaseOfTravelBinding
import com.example.hackhaton.ui.pager.FragmentPagerViewModel
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class EaseOfTravelFragment : Fragment() {
    companion object {
        fun newInstance() = EaseOfTravelFragment()
    }

    private lateinit var viewModel: FragmentPagerViewModel

    private lateinit var binding: FragmentEaseOfTravelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEaseOfTravelBinding.inflate(layoutInflater)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPagerViewModel::class.java]

        binding.tvMaxTravelTime.text = "${binding.rangeSlider.values.first().toInt()} min"

        binding.rangeSlider.addOnChangeListener(RangeSlider.OnChangeListener { slider, value, fromUser ->
            binding.tvMaxTravelTime.text = "${value.toInt()} min"
        })

    }
}