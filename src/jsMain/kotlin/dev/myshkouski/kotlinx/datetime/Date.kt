package dev.myshkouski.kotlinx.datetime

internal actual fun getLocalDate(): Date {
    return kotlin.js.Date().toLocalDate()
}

internal actual fun getUtcDate(): Date {
    return kotlin.js.Date().toUtcDate()
}
