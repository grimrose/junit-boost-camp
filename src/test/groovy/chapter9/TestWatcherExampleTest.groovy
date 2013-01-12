package chapter9

import groovy.util.logging.Slf4j
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

import static org.junit.Assert.fail

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/12
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
class TestWatcherExampleTest {

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            log.info "start: ${description.methodName}"
        }

        @Override
        protected void succeeded(Description description) {
            log.info "succeeded: ${description.methodName}"
        }

        @Override
        protected void failed(Throwable e, Description description) {
            log.warn "failed: ${description.methodName}", e
        }

        @Override
        protected void finished(Description description) {
           log.info "finished: ${description.methodName}"
        }
    }

    @Test
    void "成功するテスト"() {
        // Setup
        // Exercise
        // Verify
    }

    @Test
    void "失敗するテスト"() {
        // Setup
        // Exercise
        // Verify
        fail "NG"
    }

}
