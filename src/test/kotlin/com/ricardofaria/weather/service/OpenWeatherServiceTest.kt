package com.ricardofaria.weather.service

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.ricardofaria.weather.externalservices.OpenWeatherClient
import com.ricardofaria.weather.model.openweather.Main
import com.ricardofaria.weather.model.openweather.OpenWeatherTemperature
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class OpenWeatherServiceTest {

    lateinit var client: OpenWeatherClient
    lateinit var sut : OpenWeatherService;
    lateinit var main : Main;

    @Before
    fun init() {
        main = Main(temp = 110.0, temp_max = 50.0, temp_min = 80.0)
        val openWeather = OpenWeatherTemperature(main)

        client = mock<OpenWeatherClient>  {
            on {getWeather(any())} doReturn openWeather
            on {getWeather(any(), any())} doReturn openWeather
        }

        sut = OpenWeatherService(client)
    }

    @Test
    fun `convert 110 fahrenheit to celsius should be 43`() {
        main.temp = 110.0
        val expectedResult = 43
        assertEquals(expectedResult, sut.getTemperatureOf("Goiania"))
    }

    @Test
    fun `convert 90 fahrenheit to celsius should be 32`() {
        main.temp = 90.0
        val expectedResult = 32
        assertEquals(expectedResult, sut.getTemperatureOf(75.0, -30.0))
    }
}
