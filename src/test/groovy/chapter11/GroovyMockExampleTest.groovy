package chapter11

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import groovy.util.logging.Slf4j
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName

import java.util.concurrent.atomic.AtomicBoolean

@Slf4j
class GroovyMockExampleTest {

    @Rule
    public TestName rule = new TestName()

    @Test
    void "newDateが呼ばれることを確認する"() {
        // Setup
        def mock = new MockFor(DateFactory)
        Date current = new Date()
        AtomicBoolean isCallNextIntMethod = new AtomicBoolean(false)
        mock.demand.with {
            newDate {
                log.info "${rule.methodName}: demand newDate call."
                isCallNextIntMethod.set(true)
                current
            }
        }
        DateFactory dateFactory = mock.proxyInstance()

        // Verify
        assert dateFactory.newDate() == current
        assert isCallNextIntMethod.get()
    }

    @Test
    void "doSomethingを実行するとnewDateが呼ばれることを確認する"() {
        // Setup
        Date current = new Date()
        AtomicBoolean isCallNextIntMethod = new AtomicBoolean(false)

        DelegateObjectSample sut = new DelegateObjectSample()
        sut.dateFactory = [newDate: {
            log.info "${rule.methodName}: map newDate call."
            isCallNextIntMethod.set(true)
            current
        }] as DateFactory

        // Exercise
        sut.doSomething()

        // Verify
        assert sut.date == current
        assert isCallNextIntMethod.get()
    }

    @Test
    void "nextIntで0を返す"() {
        // Setup
        def stub = new StubFor(RandomNumberGenerator)
        stub.demand.nextInt { 0 }
        RandomNumberGenerator generator = stub.proxyInstance()
        // Verify
        assert generator.nextInt() ==  0
    }

    @Test
    void "choiceでAを返す"() {
        // Setup
        Randoms sut = new Randoms()
        sut.generator = [nextInt: { 0 }] as RandomNumberGenerator

        // Verify
        assert sut.choice(["A", "B"]) == "A"
    }

    @Test
    void "choiceでBを返す"() {
        // Setup
        Randoms sut = new Randoms()
        sut.generator = [nextInt: { 1 }] as RandomNumberGenerator

        // Verify
        assert sut.choice(['A', 'B']) == "B"
    }

}
