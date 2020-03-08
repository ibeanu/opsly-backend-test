package com.ibctec.optlytest.controller

import com.ibctec.optlytest.service.SocialService
import com.ibctec.optlytest.service.web.ReactiveWebClient
import org.junit.Test
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient.bindToController

@WebFluxTest()
internal class SocialControllerTest {

    val client = bindToController(SocialController(SocialService(ReactiveWebClient())))
            .build()

    @Test
    fun `Validate social data should return OK`() {

        client.get()
                .uri { builder ->
                    builder.scheme("http")
                            .path("/")
                            .build()
                }
                .exchange()
                .expectStatus().isOk
                .expectBody(String::class.java)
    }

}