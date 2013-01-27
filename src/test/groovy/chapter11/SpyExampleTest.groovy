package chapter11

import org.hamcrest.CoreMatchers
import org.junit.Test

import static org.junit.Assert.assertThat

class SpyExampleTest {

    @Test
    void "SpyLoggerを利用したテスト"() {
        // Setup
        SpyExample sut = new SpyExample()
        SpyLogger spy = new SpyLogger(sut.logger)
        sut.logger = spy
        // Exercise
        sut.doSomething()
        // Verify
        assertThat(spy.log.toString(), CoreMatchers.is("doSomething"))
    }

}
