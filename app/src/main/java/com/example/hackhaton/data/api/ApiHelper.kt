package com.example.hackhaton.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getProperties() = apiService.getProperties()
}