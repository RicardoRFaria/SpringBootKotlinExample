package com.ricardofaria.weather.externalservices

import com.ricardofaria.weather.model.music.MusicStyle
import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track
import org.springframework.stereotype.Service

@Service
class SpotifyClient (private val spotifyApi : SpotifyApi) {

    fun getPlaylistByGenre(musicStyle : MusicStyle): Paging<Track> {
        // TODO FIX SEARCH
        return spotifyApi.searchTracks("genre:$musicStyle.name" ).limit(10).build().execute()
    }

}

