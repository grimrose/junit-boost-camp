package chapter8

import org.junit.experimental.runners.Enclosed
import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Enclosed)
class EnclosedParameterizedTypeTest {

    @RunWith(Theories)
    static class _intのパラメータ化テスト {

        @DataPoint
        public static int INT_PARAM_1 = 3

        @DataPoint
        public static int INT_PARAM_2 = 4

        @Theory
        void "引数がint型のテストメソッド"(int param) {
            println "引数がint型のテストメソッド($param)"
        }

    }

    @RunWith(Theories)
    static class _Stringのパラメータ化テスト {
        @DataPoint
        public static String STRING_PARAM_1 = "Hello"

        @DataPoint
        public static String STRING_PARAM_2 = "World"

        @Theory
        void "引数がString型のテストメソッド"(String param) {
            println "引数がString型のテストメソッド($param)"
        }

    }

}
