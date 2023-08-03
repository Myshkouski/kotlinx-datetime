package dev.myshkouski.kotlinx.datetime

internal actual fun parseISOString(value: String): IOffsetDateTime {
    return java.time.OffsetDateTime.parse(value).convert()
}
