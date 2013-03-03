package chapter12

import org.dbunit.DatabaseUnitException
import org.dbunit.DatabaseUnitRuntimeException
import org.dbunit.dataset.ITable
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class ITableMatcher extends TypeSafeMatcher<ITable> {

    static Matcher tableOf(ITable expected) {
        new ITableMatcher(expected: expected)
    }

    private ITable expected
    String assertionMessage

    @Override
    protected boolean matchesSafely(ITable actual) {
        try {
            org.dbunit.Assertion.assertEquals(expected, actual)
        } catch (DatabaseUnitException e) {
            throw new DatabaseUnitRuntimeException(e)
        } catch (AssertionError e) {
            assertionMessage = e.message
            return false
        }
        true
    }

    @Override
    void describeTo(Description description) {
        description.appendValue(expected)
        if (!assertionMessage) return
        description.appendText("\n  >>>").appendText(assertionMessage)
    }

}
