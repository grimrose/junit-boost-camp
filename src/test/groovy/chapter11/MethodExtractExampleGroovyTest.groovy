package chapter11

import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class MethodExtractExampleGroovyTest {

    @Test
    void "doSomethingでdateに現在時刻が設定される"() {

        // Setup
        final Date current = new Date()

        MethodExtractExample.metaClass {
            newDate = {
                println("call expanded.")
                current
            }
        }

        MethodExtractExample sut = new MethodExtractExample()

        // Exercise
        sut.doSomething();

        // Verify
        assertThat(sut.date, is(current))
    }

}
