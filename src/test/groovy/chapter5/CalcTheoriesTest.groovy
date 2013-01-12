package chapter5

import org.hamcrest.CoreMatchers
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

@RunWith(Theories)
class CalcTheoriesTest {

    @DataPoints
    public static int[][] VALUES = [[0, 0, 0], [0, 1, 1], [1, 0, 1], [3, 4, 7]] as int[][]

    @Theory
    void add(int[] values) {
        Calc sut = new Calc()
        assertThat sut.add(values[0], values[1]), CoreMatchers.is(values[2])
    }

}
