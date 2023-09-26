package com.vijaydhoni.weatherapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vijaydhoni.weatherapp.BuildConfig
import com.vijaydhoni.weatherapp.R
import com.vijaydhoni.weatherapp.di.WeatherApplication
import com.vijaydhoni.weatherapp.model.Weather
import com.vijaydhoni.weatherapp.viewModel.WeatherViewModel
import com.vijaydhoni.weatherapp.viewModel.WeatherViewModelFactory
import javax.inject.Inject

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: com.vijaydhoni.weatherapp.databinding.ActivityMainBinding

    @Inject
    lateinit var factory: WeatherViewModelFactory
    private lateinit var viewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as WeatherApplication).applicationComponent.inject(this)
        viewModel = ViewModelProvider(this, factory).get(WeatherViewModel::class.java)

        viewModel.weather_data_.observe(this) {
            val weather = it.data[0]
            setUi(weather)
        }


        val array = arrayOf("ghaziabad", "hapur", "noida", "meerut")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, array)
        binding.citySpineer.adapter = adapter

        binding.viewWeatherButtn.setOnClickListener {
            binding.progressBar2.visibility = View.VISIBLE
            viewModel.getCurrentWeather(
                binding.citySpineer.selectedItem.toString(),
                BuildConfig.api_key
            )

        }

    }

    private fun setUi(weather: Weather) {

        binding.city.text = weather.cityName
        binding.temp.text = weather.temp.toString()
        binding.sunriseTime.text = "${weather.sunrise} AM"
        binding.sunsetTime.text = "${weather.sunset} PM"
        binding.dateTime.text = weather.datetime
        binding.pressure.text = "${weather.pres} mBar"
        binding.pressureName.text = "Pressure"
        binding.sunriseImage.setImageResource(R.drawable.sunrise3)
        binding.sunriseText.text = "Sunrise"
        binding.sunsetImage.setImageResource(R.drawable.sunset2)
        binding.sunsetText.text = "Sunset"
        binding.visibility.text = "${weather.vis} KM"
        binding.visibilityName.text = "Visibility"
        binding.weatherDisciption.text = weather.weather.description

        val iconCode = "c01d"
        Log.d("mytag", weather.weather.icon)
        if (weather.weather.icon == iconCode && weather.weather.icon == "c01n") {
            Log.d("mytag", "in clearsky")
            binding.weatherInfoImage.setImageResource(R.drawable.sun)
        } else {
            Log.d("mytag", "in rain")
            binding.weatherInfoImage.setImageResource(R.drawable.rain)
        }

        binding.windDir.text = weather.windDir.toString()
        binding.windDirName.text = "Wind Direction"
        binding.windSpeed.text = "${weather.windSpd} KM"
        binding.windSpeedName.text = "Wind Speed"

        binding.degre.text = "o"
        binding.celcius.text = "C"

        binding.progressBar2.visibility = View.GONE
    }


}