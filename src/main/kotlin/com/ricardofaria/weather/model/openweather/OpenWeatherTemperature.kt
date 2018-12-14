package com.ricardofaria.weather.model.openweather

data class OpenWeatherTemperature(
        val base: String,
        val clouds: Clouds,
        val cod: Int,
        val coord: Coord,
        val dt: Int,
        val id: Int,
        val main: Main,
        val name: String,
        val sys: Sys,
        val visibility: Int,
        val weather: List<Any>,
        val wind: Wind
)
