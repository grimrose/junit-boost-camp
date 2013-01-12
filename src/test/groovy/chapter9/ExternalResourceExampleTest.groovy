package chapter9

import groovy.transform.Canonical
import groovy.util.logging.Slf4j
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExternalResource

class ExternalResourceExampleTest {

    @Rule
    public ServerResource resource = new ServerResource()

    @Test
    void "should server access"() {
        // Verify
        println "${resource.dump()}"
    }


    static class ServerResource extends ExternalResource {

        Server server

        @Override
        protected void before() throws Throwable {
            server = new Server(port: 8888)
            server.start()
        }

        @Override
        protected void after() {
            server.shutdown()
        }
    }

    @Slf4j
    @Canonical
    static class Server {

        int port

        void start() {
            log.info "server start."

        }

        void shutdown() {
            log.info "server shutdown."
        }

    }

}
