package com.ricardofaria.weather.aggregator

import com.ricardofaria.weather.service.OpenWeatherService
import com.ricardofaria.weather.service.SpotifyService
import com.ricardofaria.weather.service.TemperatureToMusicStyleResolver
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified
import com.wrapper.spotify.model_objects.specification.Track
import org.springframework.stereotype.Service

@Service
class SuggestionAggregator(private val openWeatherService: OpenWeatherService, private val temperatureToMusicStyleResolver: TemperatureToMusicStyleResolver, private val spotifyService: SpotifyService) {

    fun suggestForCity(city: String): Array<Track> {
        val temperature = openWeatherService.getTemperatureOf(city)
        val musicStyle = temperatureToMusicStyleResolver.resolve(temperature)
        return spotifyService.getPlaylist(musicStyle)
    }

    fun suggestForLatLon(lat:Double, lon:Double): Array<Track> {
        val temperature = openWeatherService.getTemperatureOf(lat, lon)
        val musicStyle = temperatureToMusicStyleResolver.resolve(temperature)
        return spotifyService.getPlaylist(musicStyle)
    }

}
