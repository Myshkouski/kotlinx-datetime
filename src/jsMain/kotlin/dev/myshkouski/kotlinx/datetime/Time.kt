package dev.myshkouski.kotlinx.datetime

internal actual fun getLocalTime(): Time {
    return kotlin.js.Date().toLocalTime()
}

internal actual fun getUtcTime(): Time {
    return kotlin.js.Date().toUtcTime()
}

