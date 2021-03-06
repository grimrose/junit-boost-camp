package chapter6

import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

@RunWith(Enclosed)
class ArrayListEnclosedTest {

    public static class _listに1件追加してある場合 {
        ArrayList<String> sut

        @Before
        void setUp() {
            // Setup
            sut = new ArrayList<>()
            sut.add("A")
        }

        @Test
        void "sizeは1を返す"() {
            // Exercise
            int actual = sut.size()
            // Verify
            assertThat(actual, CoreMatchers.is(1))
        }

    }

    public static class _listに2件追加してある場合 {
        ArrayList<String> sut

        @Before
        void setUp() {
            // Setup
            sut = new ArrayList<>()
            sut.add("A")
            sut.add("B")
        }

        @Test
        void "sizeは2を返す"() {
            // Exercise
            int actual = sut.size()
            // Verify
            assertThat(actual, CoreMatchers.is(2))
        }
    }

}
