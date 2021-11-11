package com.example.hackhaton.ui.pager.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hackhaton.R
import com.example.hackhaton.ui.pager.FragmentPagerViewModel

class AccessibilityFragment : Fragment() {
    companion object {
        fun newInstance() = AccessibilityFragment()
    }

    private lateinit var viewModel: FragmentPagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_accessibility, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPagerViewModel::class.java]

    }
}