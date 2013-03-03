package chapter12

import org.dbunit.dataset.IDataSet
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder
import org.junit.Before
import org.junit.ClassRule
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

import static chapter12.ITableMatcher.tableOf
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.CoreMatchers.notNullValue
import static org.junit.Assert.assertThat

@RunWith(Enclosed)
class UserDaoTest {

    static class usersに2件のレコードがある場合 {

        @ClassRule
        public static H2DatabaseServer server = new H2DatabaseServer(dbName: 'db', schemaName: 'ut')

        @Rule
        public UserDaoDbUnitTester tester = new UserDaoDbUnitTester('fixtures.xml')

        UserDao sut

        @Before
        void setUp() {
            sut = new UserDao()
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
            def actual = tester.connection.createDataSet().getTable('users')

            def expected = new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream('expected.xml')).getTable('users')
            assertThat actual, is(tableOf(expected))
        }

    }

    static class usersに0件のレコードがある場合 {

        @ClassRule
        public static H2DatabaseServer server = new H2DatabaseServer(dbName: 'db', schemaName: 'ut')

        @Rule
        public UserDaoDbUnitTester tester = new UserDaoDbUnitTester('zero_fixtures.xml')

        UserDao sut

        @Before
        void setUp() {
            // Setup
            sut = new UserDao()
        }

        @Test
        void "getListで0件取得できる事"() {
            // Exercise
            List<String> list = sut.list
            // Verify
            assertThat list, is(notNullValue())
            assertThat list.size(), is(0)
        }

        @Test
        void "insertで1件追加できる"() {
            // Exercise
            sut.insert 'Sirou'
            // Verify
            def actual = tester.connection.createDataSet().getTable('users')
            def expected = new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream('zero_expected.xml')).getTable('users')
            assertThat actual, is(tableOf(expected))
        }

    }

    @Ignore
    static class UserDaoDbUnitTester extends DbUnitTester {

        private final String fixture

        UserDaoDbUnitTester(String fixture) {
            super('org.h2.Driver', 'jdbc:h2:tcp://localhost/db;SCHEMA=ut', 'sa', '', 'ut')
            this.fixture = fixture
        }

        @Override
        void before() {
            executeQuery "DROP TABLE IF EXISTS users"
            executeQuery "CREATE TABLE users(id INT AUTO_INCREMENT, name VARCHAR(255))"
        }

        @Override
        IDataSet createDataSet() {
            new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream(fixture))
        }
    }

}
