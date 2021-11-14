package com.example.hackhaton.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.hackhaton.MainActivity
import com.example.hackhaton.databinding.FragmentGuidedFilterBinding
import com.example.hackhaton.ui.pager.FragmentPagerViewModel
import com.example.hackhaton.ui.pager.ui.PagerFragments

class GuidedFilterFragment : Fragment() {
    companion object {
        fun newInstance() = GuidedFilterFragment()
    }

    private lateinit var viewPager: ViewPager2

    lateinit var fragmentsViewPager: ViewPagerFragmentAdapter

    private lateinit var binding: FragmentGuidedFilterBinding

    private lateinit var viewModel: FragmentPagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuidedFilterBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPagerViewModel::class.java]

        viewPager = binding.pagerFragments
        fragmentsViewPager =
            ViewPagerFragmentAdapter(childFragmentManager, this.lifecycle).apply {
                addFragment(PagerFragments.getFragments())
            }

        viewPager.adapter = fragmentsViewPager

        binding.imgPagerNext.setOnClickListener {
            scrollPagerToNext()
        }

        binding.imgPagerPrevious.setOnClickListener {
            scrollPagerToPrevious()
        }

        binding.doneButton.setOnClickListener {
            val intent =Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                binding.imgPagerNext.visibility = if (position < fragmentsViewPager.itemCount.minus(1)) {
                    binding.doneButton.isVisible =false
                    View.VISIBLE
                } else {
                    binding.doneButton.isVisible = true
                    binding.imgPagerNext.isVisible = false
                    View.GONE
                }

                binding.imgPagerPrevious.visibility = if (position > 0)
                    View.VISIBLE
                else
                    View.GONE
            }
        })
    }

    private fun scrollPagerToNext() {
        if (viewPager.currentItem < fragmentsViewPager.itemCount.minus(1))
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
    }

    private fun scrollPagerToPrevious() {
        if (viewPager.currentItem > 0)
            viewPager.setCurrentItem(viewPager.currentItem - 1, true)
    }
}