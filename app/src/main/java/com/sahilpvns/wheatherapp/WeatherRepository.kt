package com.sahilpvns.wheatherapp

import retrofit2.Response

class WeatherRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getCities(query: String): List<WeatherResponseItem> {
        return apiService.getCities(query = query)
    }

    suspend fun getWeather(locationKey: String): WheatherDetailsResponse {
        return apiService.getWeather(locationKey = locationKey)
    }


}