package chapter6

import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertThat

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/03
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
class ArrayListFlatTest {

    ArrayList<String> sut

    @Before
    void setUp() {
        // Setup
        sut = new ArrayList<>()
    }

    @Test
    void "listに1件追加してある場合、sizeは1を返す"() {
        // Setup
        sut.add("A")
        // Exercise
        int actual = sut.size()
        // Verify
        assertThat(actual, CoreMatchers.is(1))
    }

    @Test
    void "listに2件追加してある場合、sizeは2を返す"() {
        // Setup
        sut.add("A")
        sut.add("B")
        // Exercise
        int actual = sut.size()
        // Verify
        assertThat(actual, CoreMatchers.is(2))
    }

}
