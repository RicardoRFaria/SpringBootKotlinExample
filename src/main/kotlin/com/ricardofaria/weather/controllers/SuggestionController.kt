package com.ricardofaria.weather.controllers

import com.ricardofaria.weather.aggregator.SuggestionAggregator
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

@RestController
@Validated
class SuggestionController (private val aggregator: SuggestionAggregator) {

    @GetMapping("/{city}")
    fun suggestByCity(@PathVariable @NotEmpty(message = "City name can not be empty") city:String) = aggregator.suggestForCity(city)

    @GetMapping("/{lat}/{lon}")
    fun suggestByLatLon(@PathVariable @Min(-90, message = "Invalid latitude coordinate")
                        @Max(90, message = "Invalid latitude coordinate") lat: Double,
                        @PathVariable @Min(-180, message = "Invalid longitude coordinate")
                        @Max(180, message = "Invalid longitude coordinate") lon: Double)
            = aggregator.suggestForLatLon(lat, lon)


}
