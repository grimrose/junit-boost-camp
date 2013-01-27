package chapter11;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class MethodExtractExampleTest {

    @Test
    public void _doSomethingを実行するとdateに現在時刻が設定される() throws Exception {
        // Setup
        final Date current = new Date();
        MethodExtractExample sut = new MethodExtractExample() {

            @Override
            public Date newDate() {
                return current;
            }

        };

        // Exercise
        sut.doSomething();

        // Verify
        assertThat(sut.date, is(sameInstance(current)));
    }

}
