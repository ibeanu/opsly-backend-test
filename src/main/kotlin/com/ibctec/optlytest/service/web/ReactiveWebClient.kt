package com.ibctec.optlytest.service.web

import io.netty.handler.ssl.SslContext
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.util.InsecureTrustManagerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.reactive.ClientHttpConnector
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import reactor.netty.http.client.HttpClient
import java.net.URI
import java.util.*

@Component
class ReactiveWebClient {

    fun getWebClient(baseUrl: String): WebClient {
        return WebClient
                .builder()
                .baseUrl(baseUrl)
           //     .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", baseUrl))
                .build()
    }

   fun buildUri(builder: UriBuilder, path: String, params: MultiValueMap<String, String>): URI {
        return builder.path(path)
                .queryParams(params)
                .build()
    }
}