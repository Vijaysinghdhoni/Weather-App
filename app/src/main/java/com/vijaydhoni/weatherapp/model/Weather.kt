package com.vijaydhoni.weatherapp.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("app_temp")
    val appTemp: Double,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("pres")
    val pres: Double,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("vis")
    val vis: Int,
    @SerializedName("weather")
    val weather: WeatherX,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("wind_spd")
    val windSpd: Double
)