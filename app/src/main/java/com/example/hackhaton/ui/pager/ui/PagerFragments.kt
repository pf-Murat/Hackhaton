package com.example.hackhaton.ui.pager.ui

import androidx.fragment.app.Fragment

object PagerFragments {
    fun getFragments(): List<Fragment> {
        return listOf(
            EaseOfTravelFragment.newInstance(),
            FamilyFragment.newInstance(),
            LifeStyleFragment.newInstance(),
            AccessibilityFragment.newInstance(),
            EnterEmailFragment.newInstance()
        )
    }
}