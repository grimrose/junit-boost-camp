package chapter12

import groovy.util.logging.Slf4j
import org.h2.Driver
import org.h2.tools.Server
import org.h2.util.JdbcUtils
import org.junit.rules.ExternalResource

@Slf4j
class H2DatabaseServer extends ExternalResource {

    String baseDir = getClass().getResource('').file
    String dbName
    String schemaName
    boolean dataBaseToUpper = true

    Server server

    @Override
    void before() throws Throwable {
        log.info baseDir
        server = Server.createTcpServer("-baseDir", baseDir).start()
        def url = "jdbc:h2:${server.URL}/$dbName${dataBaseToUpper ? '' : ';DATABASE_TO_UPPER=false'}"
        log.info url
        Driver.load().connect(url, ['user': 'sa', 'password': ''] as Properties).with {
            try {
                log.info "$delegate"
                createStatement().execute("create schema IF NOT EXISTS $schemaName")
            } finally {
                JdbcUtils.closeSilently(delegate)
            }
        }
    }

    @Override
    void after() {
        server.shutdown()
    }

}
