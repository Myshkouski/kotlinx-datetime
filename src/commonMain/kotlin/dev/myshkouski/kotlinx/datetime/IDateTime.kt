package dev.myshkouski.kotlinx.datetime

import kotlin.math.abs

internal interface IDateTime: IDate, ITime {
    /*
     * Returns Unix timestamps in milliseconds.
     */
    val timestamp: Long

    val epochMillis get() = timestamp.toDouble()
    val epochSeconds get() = timestamp.toDouble() / 1000

    /*
     * Returns OffsetDateTime at specified offset.
     */
    fun at(offset: ZoneOffset): OffsetDateTime
}

sealed class AbstractDateTime(
    date: Date,
    time: Time,
    offset: ZoneOffset,
) : IDateTime, IDate by date, ITime by time, IZoneOffset by offset {
    override fun equals(other: Any?): Boolean {
        if (other is IDateTime) {
            return timestamp == other.timestamp
        }
        return super.equals(other)
    }

    private fun toIsoString(zoneOffset: IZoneOffset): String {
        val year = year.padStartWithZeroes(4)
        val month = (month + 1).padStartWithZeroes(2)
        val dayOfMonth = (dayOfMonth + 1).padStartWithZeroes(2)
        val hour = hour.padStartWithZeroes(2)
        val minute = minute.padStartWithZeroes(2)
        val second = second.padStartWithZeroes(2)
        val millis = millis.padStartWithZeroes(3)

        val offset = zoneOffset.toIsoOffset()

        return "${year}-${month}-${dayOfMonth}T${hour}:${minute}:${second}.${millis}${offset}"
    }

    override fun toString(): String {
        return toIsoString(this as IZoneOffset)
    }
}

private fun Number.padStartWithZeroes(count: Int): String {
    return toString().padStart(count, '0')
}

private fun IZoneOffset.toIsoOffset(): String {
//    if (offset.toInt() == 0) return "Z"
    val absOffset = abs(offset.toInt())
    val offsetHours = (absOffset / 60).padStartWithZeroes(2)
    val offsetMinutes = (absOffset % 60).padStartWithZeroes(2)
    val sign = if (offset < 0) '-' else '+'
    return "$sign$offsetHours:$offsetMinutes"
}
