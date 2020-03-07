package com.ibctec.optlytest.service

import com.ibctec.optlytest.model.SocialResponse
import com.ibctec.optlytest.service.web.ReactiveWebClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
open class SocialService @Autowired constructor(
        val webClient: ReactiveWebClient){


    public  fun getSocialResponse(): SocialResponse {
        return SocialResponse(getTwitterData().blockOptional().orElse(null),
                getFacebookData().blockOptional().orElse(null),
                getInstagramData().blockOptional().orElse(null))
    }

    private fun getTwitterData(): Mono<String> {

        return webClient.getWebClient("https://takehome.io/twitter")
                .get()
                .exchange()
                .flatMap { response -> response.bodyToMono(String::class.java) }
                .onErrorContinue{ e, t -> e.message}
    }

    private fun getFacebookData(): Mono<String> {
        return webClient.getWebClient("https://takehome.io/facebook")
                .get()
                .exchange()
                .flatMap { response -> response.bodyToMono(String::class.java) }
                .onErrorContinue{ e, t -> e.message}
    }

    private fun  getInstagramData(): Mono<String>
    {
        return webClient.getWebClient("https://takehome.io/instagram")
                .get()
                .exchange()
                .flatMap { response -> response.bodyToMono(String::class.java) }
                .onErrorContinue{ e, t -> e.message}
    }


}
