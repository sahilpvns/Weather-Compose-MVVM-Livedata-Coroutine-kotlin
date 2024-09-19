package com.sahilpvns.wheatherapp

import android.content.Intent
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val viewModel: WheatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val weatherResponse by viewModel.cities.observeAsState(emptyList())
            val error by viewModel.error.observeAsState()
            WeatherData(weatherResponse, viewModel, error)
        }
    }
}

@Composable
fun WeatherData(
    weatherResponse: List<WeatherResponseItem>, viewModel: WheatherViewModel, error: String?
) {
    Column {
        SearchScreen(viewModel)
        WeatherApp(weatherResponse)
        Text(
            text = error ?: "",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = androidx.compose.ui.graphics.Color.Red,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun SearchScreen(viewModel: WheatherViewModel) {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
            viewModel.getCities(searchText)
        },
        label = { Text(text = "Search City") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        singleLine = true

    )
}

@Composable
fun WeatherApp(weatherResponse: List<WeatherResponseItem>) {
    LazyColumn {
        items(weatherResponse) {
            WeatherListData(it)
        }
    }

}

@Composable
fun WeatherListData(weatherResponseItem: WeatherResponseItem) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), onClick = {
        val intent = Intent(context, DetailsWeatherActivity::class.java).apply {
            putExtra("locationKey", weatherResponseItem.Key)
        }
        context.startActivity(intent)
    }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = weatherResponseItem.LocalizedName)
            Text(text = weatherResponseItem.Country.LocalizedName)
        }
    }

}

