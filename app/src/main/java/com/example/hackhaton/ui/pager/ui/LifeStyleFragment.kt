package com.example.hackhaton.ui.pager.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackhaton.R
import com.example.hackhaton.databinding.FragmentEaseOfTravelBinding
import com.example.hackhaton.databinding.FragmentLifeStyleBinding
import com.example.hackhaton.ui.pager.FragmentPagerViewModel

class LifeStyleFragment : Fragment() {
    companion object {
        fun newInstance() = LifeStyleFragment()
    }

    private lateinit var viewModel: FragmentPagerViewModel


    private lateinit var binding : FragmentLifeStyleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLifeStyleBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPagerViewModel::class.java]

    }
}