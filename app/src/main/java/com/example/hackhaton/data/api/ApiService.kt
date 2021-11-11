package com.example.hackhaton.data.api

import retrofit2.http.GET

interface ApiService {

    @GET("murat-pf/hackathon/master/data.json")
    suspend fun getProperties(): List<PropertyData>

}