package com.example.hackhaton.data.api

data class PropertyData(
    val id: Int,
    val category: String,
    val type: String,
    val verified: Boolean,
    val price: Int,
    val location: String,
    val image: String,
    val bedroom: Int,
    val area: Int,
    val matchedLabels : List<String>,
    val unMatchedLabels : List<String>,
)
