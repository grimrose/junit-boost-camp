package chapter5

import org.junit.Assert
import org.junit.Test
import org.junit.experimental.categories.Category

import static org.junit.Assert.fail

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/03
 * Time: 0:30
 * To change this template use File | Settings | File Templates.
 */
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
