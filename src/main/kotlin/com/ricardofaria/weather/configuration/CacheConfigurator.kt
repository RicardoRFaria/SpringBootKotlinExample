package com.ricardofaria.weather.configuration

import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfigurator {

    companion object {
        const val TEMPERATURE_CACHE_KEY = "Temperature"
        const val MUSIC_CACHE_KEY = "Music"
        const val LAT_LON_CACHE_KEY_GENERATOR = "lat-lon-keygenerator"
    }

    @Bean(LAT_LON_CACHE_KEY_GENERATOR)
    fun keyGenerator(): KeyGenerator {
        return LatLonKeyGenerator()
    }

}
