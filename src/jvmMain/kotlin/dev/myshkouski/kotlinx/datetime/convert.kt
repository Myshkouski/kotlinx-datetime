package dev.myshkouski.kotlinx.datetime

private val java.time.ZoneOffset.totalMinutes get() = totalSeconds / 60
private val ITime.nano get() = millis.toInt() * 1_000_000

internal fun java.time.LocalDateTime.convert() = LocalDateTime(
    date = Date(
        year.toShort(),
        monthValue.toByte(),
        dayOfMonth.toByte(),
    ),
    time = Time(
        hour.toByte(),
        minute.toByte(),
        second.toByte(),
        (nano / 1_000_000).toShort(),
    ),
)

internal fun LocalDateTime.convert() = java.time.LocalDateTime.of(
    year.toInt(),
    month.toInt(),
    dayOfMonth.toInt(),
    hour.toInt(),
    minute.toInt(),
    second.toInt(),
    nano,
)

internal fun java.time.OffsetDateTime.convert() = OffsetDateTimeImpl(
    year.toShort(),
    monthValue.toByte(),
    dayOfMonth.toByte(),
    hour.toByte(),
    minute.toByte(),
    second.toByte(),
    (nano / 1_000_000).toShort(),
    offset.totalMinutes.toShort()
)

internal fun OffsetDateTime.convert() = java.time.OffsetDateTime.of(
    year.toInt(),
    month.toInt(),
    dayOfMonth.toInt(),
    hour.toInt(),
    minute.toInt(),
    second.toInt(),
    nano,
    java.time.ZoneOffset.ofTotalSeconds(totalSeconds)
)