package com.vijaydhoni.weatherapp.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("current")
    suspend fun getWeather(
        @Query("city") city: String,
        @Query("key") apikey: String
    ): Response<WeatherResponse>

}