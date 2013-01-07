package chapter7

import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.assertThat

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/08
 * Time: 0:16
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Enclosed)
class LruCacheTest {

    public static class _AとBを追加している場合 {

        LruCache<String> sut

        @Before
        void setUp() {
            // Setup
            sut = new LruCache<String>()
            sut.put "A", "valueA"
            sut.put "B", "valueB"
        }

        @Test
        void "sizeは2"() {
            // Verify
            assertThat sut.size(), is(2)
        }

        @Test
        void "get AでvalueAを返し、keysはBA"() {
            // Verify
            assertThat sut.get("A"), is("valueA")
            assertThat sut.keys.size(), is(2)
            assertThat sut.keys.get(0), is("B")
            assertThat sut.keys.get(1), is("A")
        }

        @Test
        void "get BでvalueBを返し、keysはAB"() {
            // Verify
            assertThat sut.get("B"), is("valueB")
            assertThat sut.keys.size(), is(2)
            assertThat sut.keys.get(0), is("A")
            assertThat sut.keys.get(1), is("B")
        }

        @Test
        void "get Cでnullを返し、keysはAB"() {
            // Verify
            assertThat sut.get("C"), is(nullValue())
            assertThat sut.keys.size(), is(2)
            assertThat sut.keys.get(0), is("A")
            assertThat sut.keys.get(1), is("B")
        }

        @Test
        void "put Cでsizeは3、keysはABCとなる"() {
            // Setup
            String key = "C"
            String item = "valueC"

            // Exercise
            sut.put key, item

            // Verify
            assertThat sut.size(), is(3)
            assertThat sut.keys.size(), is(3)
            assertThat sut.keys.get(0), is("A")
            assertThat sut.keys.get(1), is("B")
            assertThat sut.keys.get(2), is("C")
        }

    }

}
