package com.ricardofaria.weather.configuration

import com.ricardofaria.weather.exceptions.MusicRecomendationException
import com.ricardofaria.weather.exceptions.TemperatureException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerConfiguration {

    @ExceptionHandler(value = [MusicRecomendationException::class, TemperatureException::class])
    fun handleException(ex : Exception) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.message);
    }

}
