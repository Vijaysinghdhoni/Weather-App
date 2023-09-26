package com.vijaydhoni.weatherapp.model

import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherService: WeatherService) {

    suspend fun getWeatherByLocation(city: String,apikey: String): Response<WeatherResponse> {
        val response = weatherService.getWeather(city, apikey)
        return response
    }

}