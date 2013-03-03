package chapter12

import groovy.sql.Sql
import groovy.util.logging.Slf4j
import org.junit.*
import org.junit.experimental.runners.Enclosed
import org.junit.rules.ExternalResource
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.model.Statement

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.CoreMatchers.notNullValue
import static org.junit.Assert.assertThat

@RunWith(Enclosed)
class UserDaoYamlTest {

    static final String DB_URL = 'jdbc:h2:tcp://localhost/db;SCHEMA=ut;DATABASE_TO_UPPER=false'

    @Slf4j
    static class usersに2件のレコードがある場合 {

        @ClassRule
        public static H2DatabaseServer server = new H2DatabaseServer(dbName: 'db', schemaName: 'ut', dataBaseToUpper: false)

        @Rule
        public UserDaoYamlTestRule rule = new UserDaoYamlTestRule(fixture: 'fixtures.yaml', tables: ['users'])

        UserDao sut

        @Before
        void setUp() {
            sut = new UserDao(url: DB_URL)
        }

        @Test
        void "getListで2件取得できる事"() {
            // Exercise
            List<String> actual = sut.list
            // Verify
            assertThat actual, is(notNullValue())
            assertThat actual.size(), is(2)
            assertThat actual[0], is('Ichiro')
            assertThat actual[1], is('Jiro')
        }

        @Test
        void "insertで1件追加できる"() {
            // Exercise
            sut.insert 'Saburou'
            // Verify
            def actual = []
            rule.db.eachRow("select id, name from users") { row ->
                actual << [id: row.id, name: row.name]
            }
            def expected = YamlResourceLoader.instance.load(getClass().getResourceAsStream('expected.yaml')).users
            assert actual == expected
        }

    }

    @Slf4j
    @Ignore
    static class UserDaoYamlTestRule extends ExternalResource {

        String fixture

        List tables

        Sql db

        @Override
        protected void before() throws Throwable {
            db = Sql.newInstance(DB_URL, [user: 'sa', password: ''] as Properties)
        }

        @Override
        protected void after() {
            db.rollback()
            db.close()
        }

        @Override
        Statement apply(Statement base, Description description) {
            [evaluate: {
                before()
                createTables()
                prepareData()
                try {
                    base.evaluate()
                } finally {
                    after()
                }
            }] as Statement
        }

        void createTables() {
            db.execute("DROP TABLE IF EXISTS users")
            db.execute("CREATE TABLE users(id INT AUTO_INCREMENT, name VARCHAR(255))")
        }

        void prepareData() {
            def fixture = YamlResourceLoader.instance.load(getClass().getResourceAsStream(fixture))
            tables.each { table ->
                def dataSet = db.dataSet(table)
                fixture["$table"].each { entity ->
                    dataSet.add entity
                }
            }
        }

    }

}
