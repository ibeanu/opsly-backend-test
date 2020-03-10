package com.ibctec.optlytest.service

import com.ibctec.optlytest.model.SocialResponse
import com.ibctec.optlytest.service.web.ReactiveWebClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

private val TWITTER_URL = "https://takehome.io/twitter"

private val FACEBOOK_URL = "https://takehome.io/facebook"

private val INSTAGRAM_URL = "https://takehome.io/instagram"

@Service
open class SocialService @Autowired constructor(
        var webClient: ReactiveWebClient){


    open fun getSocialResponse(): SocialResponse {
        return SocialResponse(
                getSocialData(TWITTER_URL).blockOptional().orElse(""),
                getSocialData(FACEBOOK_URL).blockOptional().orElse(""),
                getSocialData(INSTAGRAM_URL).blockOptional().orElse(""))
    }

    private fun getSocialData(url: String) : Mono<String>{
        return webClient.getWebClient(url)
                .get()
                .exchange()
                .flatMap { response -> response.bodyToMono(String::class.java) }
                .onErrorContinue{ e, t -> e.message}
    }
}
