package com.ricardofaria.weather.configuration

import com.wrapper.spotify.SpotifyApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI

@Configuration
class SpotifyApiConfigurator(@Value("\${spotify.token.id}") val clientId: String, @Value("\${spotify.token.secret}") val secret: String) {

    @Bean
    fun getPlaylist(): SpotifyApi {
        val spotifyApi = SpotifyApi.builder().apply {
            setClientId(clientId)
            setClientSecret(secret)
            setRedirectUri(URI.create("www.google.com"))
        }.build()
        val clientCredentialsRequest = spotifyApi.clientCredentials().build()
        val clientCredentials = clientCredentialsRequest.execute()
        spotifyApi.accessToken = clientCredentials.accessToken
        return spotifyApi
    }

}
