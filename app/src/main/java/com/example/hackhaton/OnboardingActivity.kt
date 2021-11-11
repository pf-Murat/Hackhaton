package com.example.hackhaton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackhaton.databinding.ActivityOnboardingBinding
import com.example.hackhaton.ui.main.GuidedFilterFragment


class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, GuidedFilterFragment.newInstance())
            .commitNow()
    }
}