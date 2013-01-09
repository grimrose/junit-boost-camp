package chapter8

import org.hamcrest.CoreMatchers
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.yaml.snakeyaml.Yaml

import static org.junit.Assert.assertThat

@RunWith(Theories)
class CalculatorDataPointsYamlTest {

    @DataPoints
    public static Fixture[] getParams() {
        InputStream is = CalculatorDataPointsYamlTest.class.getResourceAsStream("params.yaml")
        new Yaml().load(is) as Fixture[]
    }

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
