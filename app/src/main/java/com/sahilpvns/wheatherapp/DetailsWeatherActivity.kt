package com.sahilpvns.wheatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DetailsWeatherActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val locationKey = intent.getStringExtra("locationKey")
            viewModel.getWeather(locationKey ?: "")
            val weatherDetailsResponse by viewModel.weather.observeAsState()
            WeatherDetailsScreen(weatherDetailsResponse)
        }
    }
}

@Composable
fun WeatherDetailsScreen(weatherDetailsResponse: WeatherDetailsResponse?) {
    LazyColumn {
        items(weatherDetailsResponse?.DailyForecasts ?: emptyList()) {
            WeatherDetailsScreen(it)
        }
    }



}

@Composable
fun WeatherDetailsScreen(it: DailyForecast) {
    Card(modifier = Modifier.fillMaxWidth(). padding(8.dp)) {
        Column(Modifier.padding(8.dp)) {
            Text(text = it.Date)
            Text(text = "Max Value: " +it.Temperature.Maximum.Value.toString())
            Text(text = "Min Value: " +it.Temperature.Minimum.Value.toString())
            Text(text = it.Day.IconPhrase)
            Text(text = it.Night.IconPhrase)
        }
    }


}

