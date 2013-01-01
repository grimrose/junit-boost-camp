package chapter4

import org.junit.Test

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/01
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
class AssertionTest {

    @Test
    void assertion() {
        String actual = "Hello" + " " + "World"
        assertThat(actual, is("Hello World"))
    }

}
