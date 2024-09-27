package com.sahilpvns.wheatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    private val repository = WeatherRepository()

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _cities = MutableLiveData<List<WeatherResponseItem>>()
    val cities: LiveData<List<WeatherResponseItem>> = _cities

    fun getCities(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.getCities(query)
                _cities.value = response
            } catch (e: Exception) {
                _error.value = e.message
            }

        }
    }

    private val _weather = MutableLiveData<WeatherDetailsResponse>()
    val weather: LiveData<WeatherDetailsResponse> = _weather

    fun getWeather(locationKey: String) {
        viewModelScope.launch {
            try {
                val weather = repository.getWeather(locationKey)
                _weather.value = weather
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }


}