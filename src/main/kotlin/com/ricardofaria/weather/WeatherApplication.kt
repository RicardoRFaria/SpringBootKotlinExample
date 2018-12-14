package com.ricardofaria.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class WeatherApplication

fun main(args: Array<String>) {
    runApplication<WeatherApplication>(*args)
}
