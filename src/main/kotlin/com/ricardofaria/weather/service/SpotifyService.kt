package com.ricardofaria.weather.service

import com.ricardofaria.weather.configuration.CacheConfigurator.Companion.MUSIC_CACHE_KEY
import com.ricardofaria.weather.exceptions.MusicRecomendationException
import com.ricardofaria.weather.externalservices.SpotifyClient
import com.ricardofaria.weather.model.music.MusicStyle
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified
import com.wrapper.spotify.model_objects.specification.Track
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class SpotifyService(private val spotifyClient: SpotifyClient) {

    val logger: Logger = LoggerFactory.getLogger(SpotifyService::class.java)

    // TODO FIX UNLESS
    @Cacheable(value = [MUSIC_CACHE_KEY], key = "#musicStyle", unless = "#result==null or #result.size==0")
    fun getPlaylist(musicStyle: MusicStyle): Array<Track> {
        try {
            return spotifyClient.getPlaylistByGenre(musicStyle).items
        } catch (e:Exception) {
            logger.error("Failed to retrieve music recommendation", e)
            throw MusicRecomendationException("Failed to retrieve music recommendation", e)
        }
    }

}
