package com.ricardofaria.weather.service

import com.ricardofaria.weather.configuration.CacheConfigurator.Companion.MUSIC_CACHE_KEY
import com.ricardofaria.weather.exceptions.MusicRecomendationException
import com.ricardofaria.weather.externalservices.SpotifyClient
import com.ricardofaria.weather.model.music.MusicStyle
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SpotifyService(private val spotifyClient: SpotifyClient) {

    val logger: Logger = LoggerFactory.getLogger(SpotifyService::class.java)

    @Cacheable(value = [MUSIC_CACHE_KEY], key = "#musicStyle", unless = "#result==null or #result.empty")
    fun getPlaylist(musicStyle: MusicStyle): List<String> {
        try {
            logger.info("Searching for music style : '$musicStyle'")
            return spotifyClient.getPlaylistByGenre(musicStyle).items.map { it.name }
        } catch (e:Exception) {
            logger.error("Failed to retrieve music recommendation", e)
            throw MusicRecomendationException("Failed to retrieve music recommendation", e)
        }
    }

}
