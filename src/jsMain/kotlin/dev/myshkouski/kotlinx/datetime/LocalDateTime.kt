package dev.myshkouski.kotlinx.datetime

internal actual fun getLocalDateTime(): LocalDateTime {
    return kotlin.js.Date().toLocalDateTime()
}

internal actual fun LocalDateTime.toTimestamp(): Long {
//    println("$timestamp, LocalDateTime.toTimestamp()")
    val jsDate = toJsDate()
//    println("${jsDate.getTime()}, LocalDateTime.toTimestamp()")
    return jsDate.getTime().toLong()
}

internal actual fun parseTimestampToLocalDateTime(value: Long): LocalDateTime {
    val jsDate = kotlin.js.Date(value)
    return jsDate.toLocalDateTime()
}

internal actual fun LocalDateTime.atOffset(offset: IZoneOffset): OffsetDateTime {
    val timestamp = toJsDate().getTimestampAt(offset)
    val date = kotlin.js.Date(timestamp)
    return date.toOffsetDateTime()
}

internal fun LocalDateTime.toJsDate() = kotlin.js.Date(
    year.toInt(),
    month.toInt(),
    dayOfMonth.toInt(),
    hour.toInt(),
    minute.toInt(),
    second.toInt(),
    millis.toInt(),
)
