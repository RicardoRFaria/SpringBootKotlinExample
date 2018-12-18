package com.ricardofaria.weather.configuration

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI

@Configuration
class SpotifyApiConfigurator(@Value("\${spotify.token.id}") val clientId: String, @Value("\${spotify.token.secret}") val secret: String) {

    @Bean
    fun credentialsBuilder(): ClientCredentialsRequest {
        val spotifyApi = SpotifyApi.builder().apply {
            setClientId(clientId)
            setClientSecret(secret)
            setRedirectUri(URI.create("www.google.com"))
        }.build()
        return spotifyApi.clientCredentials().build()
    }

}
