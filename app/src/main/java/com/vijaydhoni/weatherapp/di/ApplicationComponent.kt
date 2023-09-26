package com.vijaydhoni.weatherapp.di

import com.vijaydhoni.weatherapp.view.WeatherActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(weatherActivity: WeatherActivity)
}