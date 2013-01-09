package chapter8

import org.hamcrest.CoreMatchers
import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

@RunWith(Theories)
class CalculatorDataPointTest {

    @DataPoint
    public static Fixture PARAM_1 = new Fixture(x: 3, y: 4, expected: 7)
    @DataPoint
    public static Fixture PARAM_2 = new Fixture(x: 0, y: 5, expected: 5)
    @DataPoint
    public static Fixture PARAM_3 = new Fixture(x: -3, y: 1, expected: -2)

    @Theory
    void add(Fixture p) {
        Calculator sut = new Calculator()
        assertThat sut.add(p.x, p.y), CoreMatchers.is(p.expected)
    }

    static class Fixture {
        int x
        int y
        int expected
    }

}
