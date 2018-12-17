package com.ricardofaria.weather.controllers

import com.ricardofaria.weather.aggregator.SuggestionAggregator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SuggestionController (private val aggregator: SuggestionAggregator) {

    // TODO IMPLEMENT PARAMETER VALIDATION
    @GetMapping("/{city}")
    fun suggestByCity(@PathVariable city:String) = aggregator.suggestForCity(city)

    // TODO IMPLEMENT PARAMETER VALIDATION
    @GetMapping("/{lat}/{lon}")
    fun suggestByLatLon(@PathVariable lat:Double, @PathVariable lon:Double)= aggregator.suggestForLatLon(lat, lon)


}
