package dev.myshkouski.kotlinx.datetime
import kotlin.test.Test
import kotlin.test.assertEquals

class OffsetDateTimeTests {
    val dateString = "2023-02-03T18:00:52.097+00:00"

    @Test
    fun offsetDateTimeFormat() {
        val offsetDateTime = OffsetDateTime.parse(dateString).atOffset(ZoneOffset.UTC)
        assertEquals(dateString, offsetDateTime.toString())
    }

    @Test
    fun localDateTimeFormat() {
        val offsetDateTime = OffsetDateTime.parse(dateString)
        val localDateTime = offsetDateTime.toLocal()

        assertEquals(dateString, localDateTime.toString())
    }

    @Test
    fun localEqualsOffset() {
        val offsetDateTime = OffsetDateTime.parse(dateString)
        val localDateTime = OffsetDateTime.parse(dateString)
        assertEquals(offsetDateTime, localDateTime)
    }
}