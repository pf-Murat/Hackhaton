package com.example.hackhaton.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackhaton.R
import com.example.hackhaton.databinding.FragmentFiltersBinding
import com.example.hackhaton.ui.pager.FragmentPagerViewModel




class FilterFragment : Fragment() {
    companion object {
        fun newInstance() = FilterFragment()
    }

    private lateinit var viewModel: FragmentPagerViewModel

    private lateinit var binding: FragmentFiltersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFiltersBinding.inflate(layoutInflater)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPagerViewModel::class.java]


        binding.btnSmartSearch.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.filter_container, GuidedFilterFragment.newInstance(), "secondFragmentTag")
                .addToBackStack(null)
                .commit()
        }

        binding.ivSmartSearch.setOnClickListener {
            binding.btnSmartSearch.performClick()
        }

    }
}