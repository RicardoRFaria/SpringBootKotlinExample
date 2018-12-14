package com.ricardofaria.weather.service

import com.ricardofaria.weather.externalservices.OpenWeatherClient
import com.ricardofaria.weather.model.openweather.OpenWeatherTemperature
import org.springframework.stereotype.Service

@Service
class OpenWeatherService (private val openWeatherClient : OpenWeatherClient) {

    fun getTemperatureOf(city: String): Int {
        var temperature = openWeatherClient.getWeather(city).main.temp.toInt()
        return convertFahrenheitToCelsius(temperature)
    }

    fun getTemperatureOf(lat:Double, lon:Double): Int {
        var temperature =  openWeatherClient.getWeather(lat, lon).main.temp.toInt()
        return convertFahrenheitToCelsius(temperature)
    }

    private fun convertFahrenheitToCelsius(temperatureFahrenheit: Int) : Int {
        // TODO IMPLEMENT CONVERSION
        return temperatureFahrenheit;
    }

}
