package dev.myshkouski.kotlinx.datetime

@OptIn(ExperimentalJsExport::class)
@JsExport
class LocalDateTime(
    date: Date,
    time: Time,
) : AbstractDateTime(date, time, ZoneOffset.local()) {
    @JsExport.Ignore
    override val timestamp: Long get() = toTimestamp()

    override fun at(offset: ZoneOffset): OffsetDateTime {
        return atOffset(offset)
    }

    companion object {
        fun now(): LocalDateTime = getLocalDateTime()
        @JsExport.Ignore
        fun of(timestamp: Long): LocalDateTime = parseTimestampToLocalDateTime(timestamp)
        fun of(timestamp: Double): LocalDateTime = of(timestamp.toLong())
    }
}

internal expect fun getLocalDateTime(): LocalDateTime
internal expect fun parseTimestampToLocalDateTime(value: Long): LocalDateTime
internal expect fun LocalDateTime.toTimestamp(): Long
internal expect fun LocalDateTime.atOffset(offset: IZoneOffset): OffsetDateTime

val Number.epochMillis get() = LocalDateTime.of(toLong())
val Number.epochSeconds get() = LocalDateTime.of(toLong() * 1000)
