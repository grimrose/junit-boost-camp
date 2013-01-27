package chapter11

import static org.hamcrest.CoreMatchers.*
import org.junit.Test

import java.util.concurrent.atomic.AtomicBoolean

import static org.junit.Assert.assertThat

class RandomsMockTest {

    @Test
    void "choiceでAを返す"() {
        // Setup
        def options = ["A", "B"]
        Randoms sut = new Randoms()
        AtomicBoolean isCallNextIntMethod = new AtomicBoolean(false)
        sut.generator = new RandomNumberGenerator() {
            @Override
            int nextInt() {
                isCallNextIntMethod.set true
                0
            }
        }
        // Verify
        assertThat(sut.choice(options), is("A"))
        assertThat(isCallNextIntMethod.get(), is(true))
    }
}
