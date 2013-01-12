package chapter9

import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat
import static org.junit.Assert.fail

@RunWith(Enclosed)
class ExpectedExceptionExampleTest {

    public static class _例外の発生とメッセージを検証する標準的なテスト {

        @Test
        void "例外の発生とメッセージを検証する標準的なテスト"() {
            // Verify
            try {
                throwNewIllegalArgumentException()
                fail("例外が発生しない")
            } catch (IllegalArgumentException e) {
                assertThat(e.message, CoreMatchers.is("argument is null."))
            }
        }

        void throwNewIllegalArgumentException() {

        }
    }

    public static class _例外の発生とメッセージを検証するテスト {

        @Rule
        public ExpectedException expectedException = ExpectedException.none()

        @Test
        void "例外の発生とメッセージを検証するテスト"() {
            // Setup
            expectedException.expect(IllegalArgumentException)
            expectedException.expectMessage("argument is null.")
            throw new IllegalArgumentException()
        }

    }

}
