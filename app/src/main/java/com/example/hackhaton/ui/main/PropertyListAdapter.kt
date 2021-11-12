package com.example.hackhaton.ui.main

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hackhaton.R
import com.example.hackhaton.data.api.PropertyData
import com.example.hackhaton.databinding.CellFilterBinding
import com.example.hackhaton.databinding.CellPropertyBinding
import com.google.android.material.chip.Chip

class PropertyListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var mBinding:CellPropertyBinding

    var itemList= mutableListOf<PropertyData>()

    class PropertyViewVH(private val binding: CellPropertyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(propertyData: PropertyData) {
            Glide.with(binding.propertyImage).load(propertyData.image).into(binding.propertyImage)

            propertyData.matchedLabels.forEach {
                binding.tvMatchedGroup.addView(generateChip(it).apply {
                    isChecked =true
                })
            }

            propertyData.unMatchedLabels.forEach {
                binding.tvUnmatchedGroup.addView(generateChip(it).apply {
                    isActivated=false
                    isChecked =false
                    isCheckable=false
                   paintFlags= Paint.STRIKE_THRU_TEXT_FLAG
                })
            }
        }


        private fun generateChip(cText:String): Chip {
             return (LayoutInflater.from(binding.cellLayout.context).inflate(R.layout.cell_chip,null,false) as Chip).apply {
                 text=cText
             }

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