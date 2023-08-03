package dev.myshkouski.kotlinx.datetime

@OptIn(ExperimentalJsExport::class)
@JsExport
data class Time(
    override val hour: Byte,
    override val minute: Byte,
    override val second: Byte,
    override val millis: Short,
) : ITime {
    companion object {
        fun local(): Time = getLocalTime()
        fun utc(): Time = getUtcTime()
    }
}

internal expect fun getLocalTime(): Time
internal expect fun getUtcTime(): Time

internal interface ITime {
    val hour: Byte
    val minute: Byte
    val second: Byte
    val millis: Short
}
