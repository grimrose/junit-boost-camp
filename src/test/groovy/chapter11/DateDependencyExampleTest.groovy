package chapter11

import org.junit.Ignore
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import org.junit.Test

import static org.junit.Assert.assertThat

@RunWith(Enclosed)
class DateDependencyExampleTest {

    static class _システム時間に依存するメソッドのテスト {

        @Ignore
        @Test
        void "doSomethingでdateに現在時刻が設定される"() {
            // Setup
            DateDependencyExample sut = new DateDependencyExample()
            // Exercise
            sut.doSomething()
            // Verify
            assertThat(sut.date.time, is(new Date().time))
        }

    }

    static class _neｗDateメソッドをオーバーライドしたテスト {

        @Ignore
        @Test
        void "doSomethingでdateに現在時刻が設定される"() {
            // Setup
            final Date current = new Date()
            MethodExtractExample.metaClass.newDate = {->
                current
            }
            MethodExtractExample sut = new MethodExtractExample()

            // Exercise
            sut.doSomething();

            // Verify
            assertThat(sut.date.time, is(current.time))
        }

    }




}
