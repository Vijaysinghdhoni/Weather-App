package com.vijaydhoni.weatherapp.di

import android.app.Application

class WeatherApplication :Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }

}