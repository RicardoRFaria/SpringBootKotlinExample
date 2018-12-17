package com.ricardofaria.weather

import com.netflix.ribbon.proxy.annotation.Hystrix
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
@EnableCaching
class WeatherApplication
// todo enable hystrix dashboard
fun main(args: Array<String>) {
    runApplication<WeatherApplication>(*args)
}
