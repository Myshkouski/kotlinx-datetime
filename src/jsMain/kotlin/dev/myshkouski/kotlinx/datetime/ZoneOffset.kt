package dev.myshkouski.kotlinx.datetime

internal actual fun getLocalZoneOffset(): ZoneOffset {
    return kotlin.js.Date(0).toZoneOffset()
}
