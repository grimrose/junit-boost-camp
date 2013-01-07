package chapter6

import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static org.junit.Assert.assertThat

@RunWith(Enclosed)
class ItemStockTest {

    public static class _空の場合 {
        ItemStock sut

        @Before
        void setUp() {
            // Setup
            sut = new ItemStockImpl()
        }

        @Test
        void "size Aが0を返す"() {
            // Verify
            assertThat(sut.size("A"), CoreMatchers.is(0))
        }

        @Test
        void "contains Aはfalseを返す"() {
            // Verify
            assertThat(sut.contains("A"), CoreMatchers.is(false))
        }

    }

    public static class _商品Aを1件含む場合 {
        ItemStock sut

        @Before
        void setUp() {
            // Setup
            sut = new ItemStockImpl()
            sut.add("A", 1)
        }

        @Test
        void "sizeが1を返す"() {
            // Verify
            assertThat(sut.size("A"),CoreMatchers.is(1))
        }

        @Test
        void "contains Aはtrueを返す"() {
            // Verify
            assertThat(sut.contains("A"), CoreMatchers.is(true))
        }

    }

}
