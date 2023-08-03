package dev.myshkouski.kotlinx.datetime

@OptIn(ExperimentalJsExport::class)
@JsExport
data class Date(
    override val year: Short,
    override val month: Byte,
    override val dayOfMonth: Byte,
) : IDate {
    companion object {
        fun local(): Date = getLocalDate()
        fun utc(): Date = getUtcDate()
    }
}

internal expect fun getLocalDate(): Date
internal expect fun getUtcDate(): Date

interface IDate {
    val year: Short
    val month: Byte
    val dayOfMonth: Byte
}
