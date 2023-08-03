package dev.myshkouski.kotlinx.datetime

import java.time.format.DateTimeFormatter



fun java.time.OffsetDateTime.toISOString(): String = format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)

actual fun IOffsetDateTime.toISOString(): String {
    return convert().toISOString()
}

actual fun IDateTime.at(offset: IZoneOffset): IOffsetDateTime {
    return convert
}

actual fun OffsetDateTimeImpl.toLocalDateTime(): LocalDateTimeImpl {
    return convert().toLocalDateTime().convert()
}