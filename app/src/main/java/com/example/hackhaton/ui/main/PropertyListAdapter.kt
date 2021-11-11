package com.example.hackhaton.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hackhaton.data.api.PropertyData
import com.example.hackhaton.databinding.CellFilterBinding
import com.example.hackhaton.databinding.CellPropertyBinding

class PropertyListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mBinding:CellPropertyBinding

    var itemList= mutableListOf<PropertyData>()

    class PropertyViewVH(private val binding: CellPropertyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(propertyData: PropertyData) {
            binding.tvLastContacted.text= propertyData.price.toString()
            Glide.with(binding.propertyImage).load(propertyData.image).into(binding.propertyImage)
            binding.tvMatched.text = "Matched: " + propertyData.matchedLabels.joinToString { it }
            binding.tvUnmatched.text = "Unmatched: " + propertyData.unMatchedLabels.joinToString { it }
        }
    }

    class FilterViewVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType==1) {
            mBinding= CellPropertyBinding.inflate(LayoutInflater.from(parent.context))
            PropertyViewVH(mBinding)
        }else FilterViewVH(CellFilterBinding.inflate(LayoutInflater.from(parent.context)).root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PropertyViewVH)
            holder.bind(itemList[position])
    }

    fun update(list: List<PropertyData>){
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position%5==3) 0 else 1
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

}