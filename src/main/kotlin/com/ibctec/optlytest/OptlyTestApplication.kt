package com.ibctec.optlytest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class OptlyTestApplication

fun main(args: Array<String>) {
    runApplication<OptlyTestApplication>(*args)
}
