package com.example.hackhaton.data.api


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getProperties() = apiHelper.getProperties()
}