package chapter11

import org.junit.Test
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

import java.util.logging.Logger

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.assertThat
import static org.mockito.Matchers.*
import static org.mockito.Mockito.*

class MockitoExampleTest {

    @Test
    void "モックオブジェクトに定義されたメソッドの戻り値"() {
        // Setup
        List<String> mock = mock(List)
        // Verify
        assertThat(mock.get(0), is(nullValue()))
        assertThat(mock.contains("Hello"), is(false))
    }

    @Test
    void "スタブメソッドの定義"() {
        // Setup
        List<String> stub = mock(List)
        when(stub.get(0)).thenReturn("Hello")
        // Verify
        assertThat(stub.get(0), is("Hello"))
    }

    @Test(expected = IndexOutOfBoundsException)
    void "例外を送出するスタブメソッド"() {
        // Setup
        List<String> stub = mock(List)
        when(stub.get(0)).thenReturn("Hello")
        when(stub.get(1)).thenReturn("World")
        when(stub.get(2)).thenThrow(new IndexOutOfBoundsException())
        // Exercise
        stub.get(2)
    }

    @Test(expected = RuntimeException)
    void "voidの型を返すスタブメソッド"() {
        // Setup
        List<String> stub = mock(List)
        doThrow(new RuntimeException()).when(stub).clear()
        // Exercise
        stub.clear()
    }

    @Test
    void "任意の整数に対するスタブメソッド"() {
        // Setup
        List<String> stub = mock(List)
        when(stub.get(anyInt())).thenReturn("Hello")
        // Verify
        assertThat(stub.get(0), is("Hello"))
        assertThat(stub.get(1), is("Hello"))
        assertThat(stub.get(999), is("Hello"))
    }

    @Test
    void "スタブメソッドの検証"() {
        // Setup
        List<String> mock = mock(List)

        mock.clear()
        mock.add("Hello")
        mock.add("Hello")

        // Verify
        verify(mock).clear()
        verify(mock, times(2)).add("Hello")
        verify(mock, never()).add("World")
    }

    @Test
    void "部分的なモックオブジェクト"() {
        // Setup
        List list = []
        List spy = spy(list)
        when(spy.size()).thenReturn(100)
        spy.add("Hello")
        // Verify
        assertThat(spy.get(0), is("Hello"))
        assertThat(spy.size(), is(100))
    }

    @Test
    void "スパイオブジェクトの作成"() {
        // Setup
        List<String> list = new LinkedList<>()
        List spy = spy(list)
        doReturn("Mockito").when(spy).get(1)
        spy.add("Hello")
        spy.add("World")

        // Verify
        verify(spy).add("Hello")
        verify(spy).add("World")
        assertThat(spy.get(0), is("Hello"))
        assertThat(spy.get(1), is("Mockito"))
    }

    @Test
    void "ロガーのスパイオブジェクトの利用"() {
        // Setup
        SpyExample sut = new SpyExample()
        Logger spy = spy(sut.logger)
        final StringBuilder infoLog = new StringBuilder()
        doAnswer(new Answer<Void>() {
            @Override
            Void answer(InvocationOnMock invocation) {
                infoLog.append(invocation.arguments[0])
                invocation.callRealMethod()
                null
            }
        }).when(spy).info(anyString())
        sut.logger = spy

        // Exercise
        sut.doSomething()
        // Verify
        assertThat(infoLog.toString(), is("doSomething"))
    }

}
