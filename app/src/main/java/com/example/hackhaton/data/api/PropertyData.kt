package com.example.hackhaton.data.api

data class PropertyData(val id : Int,
                        val category : String,
                        val type : String,
                        val verified : Boolean,
                        val price : Int,
                        val location : String,
                        val bedroom : Int,
                        val area : Int)
