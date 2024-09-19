package com.sahilpvns.wheatherapp

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherInterface {

    // https://dataservice.accuweather.com/locations/v1/cities/search?apikey=MQPaYrYDClq4ttZt1NOHxjkHMiHsakSZ&q=Delhi

    @GET("locations/v1/cities/search")
    suspend fun getCities(
        @Query("apikey") apiKey: String = "BpftAm5assqsKu1KEGzxA4jfQ8aM0iRV",
        @Query("q") query: String): List<WeatherResponseItem>

    // https://dataservice.accuweather.com/forecasts/v1/daily/5day/202396?apikey=MQPaYrYDClq4ttZt1NOHxjkHMiHsakSZ

    @GET("forecasts/v1/daily/5day/{Key}")
    suspend fun getWeather(
        @Path("Key") locationKey: String,
        @Query("apikey") apiKey: String = "BpftAm5assqsKu1KEGzxA4jfQ8aM0iRV"): WheatherDetailsResponse

}