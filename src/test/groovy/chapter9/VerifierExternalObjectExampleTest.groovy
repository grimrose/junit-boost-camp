package chapter9

import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.rules.Verifier

import static org.hamcrest.CoreMatchers.not
import static org.junit.Assert.assertThat

class VerifierExternalObjectExampleTest {

    ErrorLog log = new ErrorLog()

    @Rule
    public ErrorLogVerifier verifier = new ErrorLogVerifier(log)

    @Test
    void "test"() {
        log.logs.add "error log."
    }

    static class ErrorLogVerifier extends Verifier {
        final ErrorLog log

        ErrorLogVerifier(ErrorLog log) {
            this.log = log
        }

        @Override
        protected void verify() throws Throwable {
            assertThat log.size(), CoreMatchers.is(not(0))
        }
    }

    static class ErrorLog {

        List<String> logs = []

        int size() {
            logs.size()
        }
    }

}
