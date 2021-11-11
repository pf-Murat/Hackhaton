package com.example.hackhaton.ui.pager.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackhaton.R
import com.example.hackhaton.databinding.ActivityOnboardingBinding
import com.example.hackhaton.databinding.FragmentAccessibilityBinding
import com.example.hackhaton.databinding.FragmentGuidedFilterBinding
import com.example.hackhaton.ui.pager.FragmentPagerViewModel

class AccessibilityFragment : Fragment() {
    companion object {
        fun newInstance() = AccessibilityFragment()
    }

    private lateinit var viewModel: FragmentPagerViewModel

    private lateinit var binding : FragmentAccessibilityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccessibilityBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPagerViewModel::class.java]

    }
}