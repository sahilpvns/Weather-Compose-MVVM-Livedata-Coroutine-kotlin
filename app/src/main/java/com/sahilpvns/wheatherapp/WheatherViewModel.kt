package com.sahilpvns.wheatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WheatherViewModel: ViewModel() {
    private val repository = WeatherRepository()

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _cities = MutableLiveData<List<WeatherResponseItem>>()
    val cities: LiveData<List<WeatherResponseItem>> = _cities

    fun getCities(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.getCities(query)
                    _cities.postValue(response)
            } catch (e: Exception) {
                _error.postValue(e.message)
            }

        }
    }

    private val _weather = MutableLiveData<WheatherDetailsResponse>()
    val weather: LiveData<WheatherDetailsResponse> = _weather

    fun getWeather(locationKey: String) {
        viewModelScope.launch {
            try {
                val weather = repository.getWeather(locationKey)
                _weather.postValue(weather)
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }


}