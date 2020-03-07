package com.ibctec.optlytest.controller

import com.ibctec.optlytest.model.SocialResponse
import com.ibctec.optlytest.service.SocialService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class SocialController @Autowired constructor(
        var socialService: SocialService) {

    @GetMapping("/")
    fun getSocialData(): ResponseEntity<SocialResponse> {
        return ResponseEntity(socialService.getSocialResponse(), HttpStatus.OK)
    }

}