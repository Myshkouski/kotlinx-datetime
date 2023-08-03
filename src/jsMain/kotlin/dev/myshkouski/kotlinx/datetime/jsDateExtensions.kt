package dev.myshkouski.kotlinx.datetime

internal fun kotlin.js.Date.toLocalTime() = Time(
    getHours().toByte(),
    getMinutes().toByte(),
    getSeconds().toByte(),
    getMilliseconds().toShort(),
)

internal fun kotlin.js.Date.toUtcTime() = Time(
    getHours().toByte(),
    getMinutes().toByte(),
    getSeconds().toByte(),
    getMilliseconds().toShort(),
)

internal fun kotlin.js.Date.toLocalDate() = Date(
    getFullYear().toShort(),
    getMonth().toByte(),
    getDay().toByte(),
)

internal fun kotlin.js.Date.toUtcDate() = Date(
    getUTCFullYear().toShort(),
    getUTCMonth().toByte(),
    getUTCDay().toByte(),
)

internal fun kotlin.js.Date.toLocalDateTime() = LocalDateTime(toLocalDate(), toLocalTime())

internal fun kotlin.js.Date.getOffset(): Short {
    return (getTimezoneOffset() * -1).toShort()
}

internal fun kotlin.js.Date.toZoneOffset() = ZoneOffset(getOffset())

internal fun kotlin.js.Date.getLocalTimestamp(): Long {
    return getTime().toLong()
}

/**
 * Get timestamp of {@code kotlin.js.Date} but assumes that
 * its timezone offset is set to specified {@param zoneOffset}.
 * @param zoneOffset
 * @return UNIX timestamp
 */
internal fun kotlin.js.Date.getTimestampAt(zoneOffset: IZoneOffset): Long {
    return getLocalTimestamp() + toZoneOffset().offset - zoneOffset.offset
}

internal fun kotlin.js.Date.toOffsetDateTime(): OffsetDateTime {
    return OffsetDateTime(
        toLocalDate(),
        toLocalTime(),
        toZoneOffset(),
    )
}
