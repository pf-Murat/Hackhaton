package com.example.hackhaton.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val arrayList: ArrayList<Fragment> = ArrayList()

    fun addFragment(fragment: Fragment) {
        arrayList.add(fragment)
    }

    fun addFragment(fragments: List<Fragment>) {
        arrayList.addAll(fragments)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun createFragment(position: Int): Fragment {
        return arrayList[position]
    }
}