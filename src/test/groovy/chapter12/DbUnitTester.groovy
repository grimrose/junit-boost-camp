package chapter12

import groovy.util.logging.Slf4j
import org.dbunit.AbstractDatabaseTester
import org.dbunit.database.DatabaseConfig
import org.dbunit.database.DatabaseConnection
import org.dbunit.database.IDatabaseConnection
import org.dbunit.dataset.IDataSet
import org.dbunit.ext.h2.H2DataTypeFactory
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

import java.sql.DriverManager

@Slf4j
abstract class DbUnitTester extends AbstractDatabaseTester implements TestRule {

    final String url
    final String userName
    final String password

    DbUnitTester(String driver, String url, String userName = null, String password = null, String schema = null) {
        super(schema)
        this.url = url
        this.userName = userName
        this.password = password
        assertNotNullNorEmpty 'driverClass', driver
        try {
            Class.forName(driver)
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e)
        }
    }

    @Override
    IDatabaseConnection getConnection() {
        def connection = new DatabaseConnection(
                !userName && !password ? DriverManager.getConnection(url) : DriverManager.getConnection(url, userName, password)
                , schema)
        connection.with {
            config.setProperty DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory()
        }
        log.info "$connection"
        connection
    }

    void executeQuery(String query) {
        getConnection().connection.with {
            try {
                createStatement().execute(query)
                commit()
            } finally {
                close()
            }
        }
    }

    void before() {}

    void after() {}

    abstract IDataSet createDataSet()

    @Override
    Statement apply(Statement base, Description description) {
        [evaluate: {
            before()
            setDataSet(createDataSet())
            onSetup()
            try {
                base.evaluate()
            } finally {
                try {
                    after()
                } finally {
                    onTearDown()
                }
            }
        }] as Statement
    }

}
