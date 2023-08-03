package dev.myshkouski.kotlinx.datetime

internal actual fun getOffsetDateTime(): OffsetDateTime {
    val jsDate = kotlin.js.Date()
    return OffsetDateTime(
        date = jsDate.toLocalDate(),
        time = jsDate.toLocalTime(),
        offset = jsDate.toZoneOffset(),
    )
}

internal actual fun parseToOffsetDateTime(value: String): OffsetDateTime {
    val timestamp = kotlin.js.Date.parse(value)
    return kotlin.js.Date(timestamp).toOffsetDateTime()
}

internal actual fun OffsetDateTime.atOffset(offset: IZoneOffset): OffsetDateTime {
    TODO()
}

internal actual fun parseTimestampToOffsetDateTime(value: Long): OffsetDateTime {
    TODO()
}

internal actual fun OffsetDateTime.toTimestamp(): Long {
    return toJsDate().getTime().toLong()
//    return toJsDate().getTimestampAt(this as IZoneOffset)
}

private fun OffsetDateTime.toJsDate() = kotlin.js.Date(
    year.toInt(),
    month.toInt(),
    dayOfMonth.toInt(),
    hour.toInt(),
    minute.toInt(),
    second.toInt(),
    millis.toInt(),
)
