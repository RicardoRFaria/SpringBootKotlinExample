package com.ricardofaria.weather.service

import com.ricardofaria.weather.model.music.MusicStyle
import org.springframework.stereotype.Service

@Service
class TemperatureToMusicStyleResolver {

    fun resolve(temperature: Int) : MusicStyle {
        return when {
            temperature >= 30 -> MusicStyle.PARTY
            temperature >= 15 -> MusicStyle.POP
            temperature >= 10 -> MusicStyle.ROCK
            else -> MusicStyle.CLASSICAL
        }
    }
}
