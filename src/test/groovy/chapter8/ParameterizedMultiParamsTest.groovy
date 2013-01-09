package chapter8

import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories)
class ParameterizedMultiParamsTest {

    @DataPoint
    public static int INT_PARAM_1 = 3

    @DataPoint
    public static int INT_PARAM_2 = 4

    @DataPoint
    public static String STRING_PARAM_1 = "Hello"

    @DataPoint
    public static String STRING_PARAM_2 = "World"

    @Theory
    void "テストメソッド"(int intParam, String strParam) {
        println "テストメソッド($intParam, $strParam)"
    }

}
