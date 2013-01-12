package chapter9

import static org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.rules.TestName


class RuleExampleTest {

    @Rule
    public TestName testName = new TestName()

    @Rule
    public ExpectedException expectedException = ExpectedException.none()

    @Test
    void "show TestName"() {
        // Setup
        expectedException.expect IllegalArgumentException.class
        expectedException.expectMessage nullValue()
        // Exercise
        throw new IllegalArgumentException(testName.methodName)
    }

}
