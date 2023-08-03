package dev.myshkouski.kotlinx.datetime

@OptIn(ExperimentalJsExport::class)
@JsExport
class OffsetDateTime(
    date: Date,
    time: Time,
    offset: ZoneOffset,
) : AbstractDateTime(date, time, offset) {
    @JsExport.Ignore
    override val timestamp: Long get() = toTimestamp()

    override fun at(offset: ZoneOffset): OffsetDateTime {
        return atOffset(offset)
    }

    companion object {
        fun now(): OffsetDateTime = getOffsetDateTime()
        fun parse(value: String): OffsetDateTime = parseToOffsetDateTime(value)
        @JsExport.Ignore
        fun of(timestamp: Long): OffsetDateTime = parseTimestampToOffsetDateTime(timestamp)
        fun of(timestamp: Double): OffsetDateTime = of(timestamp.toLong())
    }
}

fun OffsetDateTime.toLocal(): LocalDateTime {
    return timestamp.epochMillis
}

internal expect fun getOffsetDateTime(): OffsetDateTime
internal expect fun OffsetDateTime.toTimestamp(): Long
internal expect fun OffsetDateTime.atOffset(offset: IZoneOffset): OffsetDateTime
internal expect fun parseToOffsetDateTime(value: String): OffsetDateTime
internal expect fun parseTimestampToOffsetDateTime(value: Long): OffsetDateTime

internal interface IOffsetDateTime: IDateTime, IZoneOffset
