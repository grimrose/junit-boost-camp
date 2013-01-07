package chapter4

import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@RunWith(Enclosed)
class AssertionTest {

    public static class _リスト_4_1 {

        @Test
        void assertion() {
            String actual = "Hello" + " " + "World"
            assertThat(actual, is("Hello World"))
        }

    }

    public static class _リスト_4_2 {

        @Test
        void "なにか難しいけど重要なテストケース"() {
            fail "TODO テストコードを実装する"
        }

    }

    public static class _特定のステップが呼び出されると失敗となるテスト {

        def sut

        @Before
        void setUp() {
            sut = new _テスト対象クラス()
        }

        @Test(expected = IllegalArgumentException.class)
        void "timeoutがtrueのときにロジックが実行されないこと"() {
            // SetUp
            Runnable logic = new Runnable() {
                @Override
                void run() {
                    fail "run が呼ばれてしまった"
                }
            }
            sut.timeOut = true

            // Exercise
            sut.invoke(logic)
        }

        static class _テスト対象クラス {

            boolean timeOut

            void invoke(Runnable logic) {

            }

        }
    }


    public static class _Matcher_APIによるアサーションの特徴 {

        @Test
        void "可読性の高い記述"() {
            int expected = 7
            int actual = add(3, 4)

            assertThat(actual, is(expected))

            assertEquals(expected, actual)
        }

        int add(int x, int y) {
            x + y
        }

        @Test
        void "柔軟な比較"() {
            // SetUp
            def sut = new _テスト対象クラス(list: ["Hello"])

            List<String> actual = sut.list;

            assertTrue(actual.contains("Hello"))

            assertThat(actual, hasItem("Hello"))
        }

        static class _テスト対象クラス {

            private List<String> list

            List<String> getList() {
                list
            }

        }

    }

}
