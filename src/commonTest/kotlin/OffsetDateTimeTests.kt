
import dev.myshkouski.kotlinx.datetime.AbstractDateTime
import dev.myshkouski.kotlinx.datetime.OffsetDateTime
import dev.myshkouski.kotlinx.datetime.toLocal
import kotlin.test.Test
import kotlin.test.assertEquals

class OffsetDateTimeTests {
    val dateString = "2023-02-03T18:00:52.097+03:00"

    @Test
    fun offsetDateTimeFormat() {
        val offsetDateTime = OffsetDateTime.parse(dateString)
        assertEquals(dateString, offsetDateTime.toString())
    }

    @Test
    fun localDateTimeFormat() {
        val offsetDateTime = OffsetDateTime.parse(dateString)
        val localDateTime = offsetDateTime.toLocal()

        assertEquals(dateString, localDateTime.toString())
    }

    @Test
    fun localEqualsOffset() {
        val offsetDateTime = OffsetDateTime.parse(dateString)
        val localDateTime = OffsetDateTime.parse(dateString)
        assertEquals<AbstractDateTime>(offsetDateTime, localDateTime)
    }
}