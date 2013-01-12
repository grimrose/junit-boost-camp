package chapter9

import org.junit.After

import static org.hamcrest.CoreMatchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.Verifier

import static org.junit.Assert.assertThat

class VerifierExampleTest {

    @Rule
    public Verifier verifier = new Verifier() {

        @Override
        protected void verify() throws Throwable {
            assertThat("value should be 0.", sut.value, is(0))
        }
    };
    VerifierExample sut;

    @Before
    void setUp() {
        // Setup
        sut = new VerifierExample()
    }

    @After
    void tearDown() {
        sut.set 0
    }

    @Test
    void "getValueで計算結果を取得する"() {
        // Setup
        sut.set 200
        sut.add(100)
        sut.minus(50)
        // Exercise
        int actual = sut.value
        // Verify
        assertThat actual, is(250)
    }

    static class VerifierExample {

        int value

        void set(int i) {
            value = i
        }

        void add(int i) {
            value += i
        }

        void minus(int i) {
            value -= i
        }

    }

}
