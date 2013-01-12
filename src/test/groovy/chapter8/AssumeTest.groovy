package chapter8

import org.hamcrest.CoreMatchers
import org.junit.Test

import static org.junit.Assert.fail
import static org.junit.Assume.assumeThat

class AssumeTest {

    @Test
    void "assume that"() {
        // Verify
        assumeThat(1, CoreMatchers.is(0))
        fail "この行は実行されない"
    }

}
