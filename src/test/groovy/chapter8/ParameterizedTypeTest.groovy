package chapter8

import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(Enclosed)
class ParameterizedTypeTest {

    @RunWith(Theories)
    static class _JUnitの場合 {

        @DataPoint
        public static int INT_PARAM_1 = 3

        @DataPoint
        public static int INT_PARAM_2 = 4

        @DataPoint
        public static String STRING_PARAM_1 = "Hello"

        @DataPoint
        public static String STRING_PARAM_2 = "World"

        @Theory
        void "引数がint型のテストメソッド"(int param) {
            println "引数がint型のテストメソッド($param)"
        }

        @Theory
        void "引数がString型のテストメソッド"(String param) {
            println "引数がString型のテストメソッド($param)"
        }

    }

    static class _Spockの場合 extends Specification {

        @Unroll
        def "引数がint型のテストメソッド(#param)"() {
            expect:
            println "引数がint型のテストメソッド($param)"
            true

            where:
            param | _
            3     | _
            4     | _
        }

    }

}
