package chapter4

import org.joda.time.DateTime
import org.junit.Test

import static org.junit.Assert.*
import static org.hamcrest.CoreMatchers.*
import static chapter4.IsDate.*

class IsDateTest {

    @Test
    void "日付の比較"() {
        DateTime dateTime = DateTime.parse("2013-01-01")
        Date actual = dateTime.toDate()

        assertThat(actual, is(dateOf(2013, 2, 10)))
    }

}
