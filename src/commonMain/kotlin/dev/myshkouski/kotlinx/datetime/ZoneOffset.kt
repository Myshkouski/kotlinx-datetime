package dev.myshkouski.kotlinx.datetime

@OptIn(ExperimentalJsExport::class)
@JsExport
data class ZoneOffset(
    override val offset: Short
) : IZoneOffset {
    override fun equals(other: Any?): Boolean {
        if (other is IZoneOffset) {
            return offset == other.offset
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return offset.hashCode()
    }

    companion object {
        val UTC = ZoneOffset(0)
        fun local(): ZoneOffset = getLocalZoneOffset()
    }
}

internal interface IZoneOffset {
    /*
     * Represents timezone offset in minutes
     */
    val offset: Short
}

internal expect fun getLocalZoneOffset(): ZoneOffset
