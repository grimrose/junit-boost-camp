package chapter8

import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories)
class ParameterizedMultiSameTypeParamsTest {

    @DataPoint
    public static int INT_PARAM_1 = 3

    @DataPoint
    public static int INT_PARAM_2 = 4

    @Theory
    void "テストメソッド"(int x, int y) {
        println "テストメソッド($x, $y)"
    }

}
