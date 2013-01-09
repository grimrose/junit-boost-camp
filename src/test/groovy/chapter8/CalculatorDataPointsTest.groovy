package chapter8

import org.hamcrest.CoreMatchers
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

@RunWith(Theories)
class CalculatorDataPointsTest {

    @DataPoints
    public static Fixture[] PARAMS = [
            new Fixture(x: 3, y: 4, expected: 7),
            new Fixture(x: 0, y: 5, expected: 5),
            new Fixture(x: -3, y: 1, expected: -2)
    ] as Fixture[]

    @Theory
    void add(Fixture p) {
        println "${p.dump()}"
        Calculator sut = new Calculator()
        assertThat sut.add(p.x, p.y), CoreMatchers.is(p.expected)
    }

    static class Fixture {
        int x
        int y
        int expected
    }

}
