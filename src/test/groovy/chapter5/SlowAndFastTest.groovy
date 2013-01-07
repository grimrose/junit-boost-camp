package chapter5

import org.junit.Test
import org.junit.experimental.categories.Category

import static org.junit.Assert.fail

class SlowAndFastTest {

    @Test
    void "fast test 01"() {
        // Setup
        // Exercise
        // Verify
    }

    @Test
    @Category(SlowTests)
    void "slow test 01"() {
        // Setup
        // Exercise
        // Verify
        fail()
    }

    @Test
    @Category(SlowTests)
    void "slow test 02"() {
        // Setup
        // Exercise
        // Verify
        fail()
    }
}
