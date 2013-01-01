package chapter5

import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.JUnitCore

import static org.junit.Assert.assertThat

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/01
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
class CalcTest {

    @Test
    void "addに3と4を与えると7を返す"() {
        // SetUp
        Calc sut = new Calc()
        assertThat(sut.add(3, 4), CoreMatchers.is(7))
    }

    static class Calc {

        int add(int x, int y) {
            x + y
        }
    }

    public static void main(String[] args) {
        JUnitCore.main(CalcTest.class.getName())
    }
}
