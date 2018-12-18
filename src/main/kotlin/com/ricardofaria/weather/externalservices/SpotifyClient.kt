package com.ricardofaria.weather.externalservices

import com.ricardofaria.weather.model.music.MusicStyle
import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.credentials.ClientCredentials
import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest
import org.springframework.stereotype.Service

@Service
class SpotifyClient (private val clientCredentialsRequest: ClientCredentialsRequest) {

    private var clientCredentials : ClientCredentials? = null

    fun getPlaylistByGenre(musicStyle : MusicStyle): Paging<Track> {
        return getSpotifyApi().searchTracks("${musicStyle.spotifyName}" ).limit(10).build().execute()
    }

    private fun getSpotifyApi() : SpotifyApi {
        val spotifyApi = SpotifyApi.builder().build()
        if (clientCredentials == null || clientCredentials?.expiresIn ?: 0 <= 5) {
            clientCredentials = clientCredentialsRequest.execute()
        }
        spotifyApi.accessToken = clientCredentials?.accessToken
        return spotifyApi
    }

}

