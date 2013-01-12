package chapter9

import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.rules.ErrorCollector
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/12
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Enclosed)
class ShopInfoTest {

    public static class _インスタンス化テスト {

        @Rule
        public ErrorCollector ec = new ErrorCollector()

        @Test
        void "デフォルトコンストラクタ"() {
            // Exercise
            ShopInfo instance = new ShopInfo()
            // Verify
            ec.checkThat instance, is(notNullValue())
            ec.checkThat(instance.id, is(nullValue()))
            ec.checkThat(instance.name, is(""))
            ec.checkThat(instance.address, is(""))
            ec.checkThat(instance.url, is(nullValue()))
        }

    }

    static class ShopInfo {
        Long id
        String name = ""
        String address = ""
        URL url
    }

}
