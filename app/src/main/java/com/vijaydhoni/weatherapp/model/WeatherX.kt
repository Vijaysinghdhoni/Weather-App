package com.vijaydhoni.weatherapp.model


import com.google.gson.annotations.SerializedName

data class WeatherX(

    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)