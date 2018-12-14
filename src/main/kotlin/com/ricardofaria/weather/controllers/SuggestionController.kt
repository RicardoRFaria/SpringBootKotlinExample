package com.ricardofaria.weather.controllers

import com.ricardofaria.weather.aggregator.SuggestionAggregator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SuggestionController (private val aggregator: SuggestionAggregator) {

    @GetMapping("/{city}")
    fun suggestByCity(@PathVariable city:String): List<String> {
        return aggregator.suggestForCity(city)
    }

    @GetMapping("/{lat}/{lon}")
    fun suggestByLatLon(@PathVariable lat:Double, @PathVariable lon:Double): List<String> {
        return aggregator.suggestForLatLon(lat, lon)
    }


}
