package com.vijaydhoni.weatherapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vijaydhoni.weatherapp.model.WeatherRepository
import com.vijaydhoni.weatherapp.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val weather_data = MutableLiveData<WeatherResponse>()
    val weather_data_: LiveData<WeatherResponse>
        get() = weather_data

    fun getCurrentWeather(city: String, apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = weatherRepository.getWeatherByLocation(city, apiKey)
            if (response.isSuccessful && response.body() != null) {
                weather_data.postValue(response.body())
            }

        }
    }
}