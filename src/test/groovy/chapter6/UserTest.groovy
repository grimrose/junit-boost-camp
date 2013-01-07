package chapter6

import org.hamcrest.CoreMatchers
import org.junit.Ignore
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

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
            "nobody";
        }

        boolean isAdmin() {
            false;
        }
    }

}
