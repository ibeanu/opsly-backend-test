package com.ibctec.optlytest.service

import com.ibctec.optlytest.service.web.ReactiveWebClient
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Mono

@SpringBootTest
internal class SocialServiceTest {
    @Mock
    lateinit var  webClient: ReactiveWebClient

    @InjectMocks
    lateinit var socialService: SocialService

    fun `check social should return twitter data`() {
        val mono = Mono.just(Twitter(listOf("test1", "test2")))

    }
}