package com.ricardofaria.weather.service

import com.ricardofaria.weather.configuration.CacheConfigurator.Companion.LAT_LON_CACHE_KEY_GENERATOR
import com.ricardofaria.weather.configuration.CacheConfigurator.Companion.TEMPERATURE_CACHE_KEY
import com.ricardofaria.weather.exceptions.TemperatureException
import com.ricardofaria.weather.externalservices.OpenWeatherClient
import com.ricardofaria.weather.model.openweather.OpenWeatherTemperature
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class OpenWeatherService(private val openWeatherClient: OpenWeatherClient) {

    val logger: Logger = LoggerFactory.getLogger(OpenWeatherService::class.java)

    @Cacheable(value = [TEMPERATURE_CACHE_KEY], key = "#city")
    fun getTemperatureOf(city: String): Int {
        var weather : OpenWeatherTemperature? = null
        try {
            weather = openWeatherClient.getWeather(city)
        } catch (e: Exception) {
            logger.error("Failed to retrieve temperature for city: '$city'", e)
            throw TemperatureException("Failed to retrieve temperature for city: '$city'", e)
        }
        return weather.main.temp.convertFahrenheitToCelsius()
    }

    @Cacheable(value = [TEMPERATURE_CACHE_KEY], keyGenerator = LAT_LON_CACHE_KEY_GENERATOR)
    fun getTemperatureOf(lat: Double, lon: Double): Int {
        var weather : OpenWeatherTemperature? = null
        try {
             weather = openWeatherClient.getWeather(lat, lon)
        } catch (e: Exception) {
            logger.error("Failed to retrieve temperature for lat: '$lat', lon: '$lon'", e)
            throw TemperatureException("Failed to retrieve temperature for lat: '$lat', lon: '$lon'", e)
        }
        return weather.main.temp.convertFahrenheitToCelsius()
    }

    private fun Double.convertFahrenheitToCelsius() = (this.toInt() - 32) * 5 / 9;


}
