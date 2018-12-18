package com.ricardofaria.weather.externalservices

import com.ricardofaria.weather.model.openweather.OpenWeatherTemperature
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@FeignClient("openweather", url = "\${openweather.api.url}")
interface OpenWeatherClient {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = arrayOf("/weather?APPID=\${openweather.api.key}&units=imperial"))
    fun getWeather(@RequestParam("q") city: String): OpenWeatherTemperature

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = arrayOf("/weather?APPID=\${openweather.api.key}&units=imperial"))
    fun getWeather(@RequestParam("lat") lat:Double, @RequestParam("lon") lon:Double): OpenWeatherTemperature

}
