package com.vijaydhoni.weatherapp.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("data")
    val data: List<Weather>
)