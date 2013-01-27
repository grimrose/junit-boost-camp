package chapter11

import org.junit.Test

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.assertThat

class DelegateObjectSampleTest {

    @Test
    void "doSomethingを実行するとdateに現在時刻が設定される"() {

        // Setup
        Date current = new Date()
        DelegateObjectSample sut = new DelegateObjectSample()
        sut.dateFactory = new DateFactory() {

            @Override
            Date newDate() {
                current
            }

        }
        // Exercise
        sut.doSomething()
        // Verify
        assertThat(sut.date, is(sameInstance(current)))
    }

}
