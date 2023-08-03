package dev.myshkouski.kotlinx.datetime

import kotlin.test.Test

class LocalDateTimeTests {
    @Test
    fun toJsDate() {
        val date = LocalDateTime.now()
        println(date)
        println(date.toJsDate().toISOString())
    }
}