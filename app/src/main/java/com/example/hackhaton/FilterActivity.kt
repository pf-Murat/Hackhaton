package com.example.hackhaton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackhaton.databinding.ActivityFilterBinding
import com.example.hackhaton.databinding.ActivityMainBinding
import com.example.hackhaton.ui.main.FilterFragment
import com.example.hackhaton.ui.main.PropertyListingFragment

class FilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(
            binding.filterContainer.id,
            FilterFragment.newInstance()
        ).commit()
    }
}