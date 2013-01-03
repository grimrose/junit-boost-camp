package chapter6

import org.hamcrest.CoreMatchers
import org.junit.Ignore
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/04
 * Time: 0:00
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Enclosed)
class UserTest {

    public static class _インスタンス化テスト {

        @Test
        void "デフォルトコンストラクタ"() {
            // Setup
            User instance = new User()
            // Verify
            assertThat(instance.getName(), CoreMatchers.is("nobody"))
            assertThat(instance.isAdmin(), CoreMatchers.is(false))
        }

    }

    @Ignore
    static class User {

        String getName() {
            return "nobody";  //To change body of created methods use File | Settings | File Templates.
        }

        boolean isAdmin() {
            return false;  //To change body of created methods use File | Settings | File Templates.
        }
    }

}
