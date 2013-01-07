package chapter5

import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.JUnitCore

import static org.junit.Assert.assertThat

class CalcTest {

    @Test
    void "addに3と4を与えると7を返す"() {
        // SetUp
        Calc sut = new Calc()
        assertThat(sut.add(3, 4), CoreMatchers.is(7))
    }

    public static void main(String[] args) {
        JUnitCore.main(CalcTest.class.getName())
    }
}
