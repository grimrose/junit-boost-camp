package chapter11

import org.hamcrest.CoreMatchers
import org.junit.Test

import static org.junit.Assert.assertThat

class RandomsTest {

    @Test
    void "choiceでAを返す"() {
        // Setup
        def options = ['A','B']
        Randoms sut = new Randoms()

        sut.generator = new RandomNumberGeneratorStub(0)
        // Verify
        assertThat(sut.choice(options), CoreMatchers.is("A"))
    }

    @Test
    void "choiceでBを返す"() {
        // Setup
        def options = ['A','B']
        Randoms sut = new Randoms()

        sut.generator = new RandomNumberGeneratorStub(1)
        // Verify
        assertThat(sut.choice(options), CoreMatchers.is("B"))
    }

}
