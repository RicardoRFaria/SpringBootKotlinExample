package com.ricardofaria.weather.aggregator

import com.ricardofaria.weather.service.OpenWeatherService
import com.ricardofaria.weather.service.TemperatureToMusicStyleResolver
import org.springframework.stereotype.Service

@Service
class SuggestionAggregator(private val openWeatherService: OpenWeatherService, private val temperatureToMusicStyleResolver: TemperatureToMusicStyleResolver) {

    fun suggestForCity(city: String): List<String> {
        val temperature = openWeatherService.getTemperatureOf(city)
        val musicStyle = temperatureToMusicStyleResolver.resolve(temperature)
        return suggest()
    }

    fun suggestForLatLon(lat:Double, lon:Double): List<String> {
        val temperature = openWeatherService.getTemperatureOf(lat, lon)
        val musicStyle = temperatureToMusicStyleResolver.resolve(temperature)
        return suggest()
    }

    private fun suggest(): ArrayList<String> {
        return arrayListOf("One", "Two")
    }

}
