package com.example.hackhaton.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hackhaton.data.api.*
import com.example.hackhaton.databinding.FragmentPropertyListBinding

class PropertyListingFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var mAdapter: PropertyListAdapter

    private lateinit var mBinding: FragmentPropertyListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPropertyListBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = PropertyListAdapter()
        mBinding.list.adapter = mAdapter

        viewModel.getProperties().observe(viewLifecycleOwner, Observer {
            when (it.status) {

                Status.SUCCESS -> {
                    println(" şşş " + it.data)
                    it.data?.let { it1 ->
                        mAdapter.update(it1)
                    }
                }
                Status.ERROR -> {
                    println(" şşş " + it.message)
                }
                Status.LOADING -> {
                    println(" şşş loading  ")
                }
            }
        })
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

}