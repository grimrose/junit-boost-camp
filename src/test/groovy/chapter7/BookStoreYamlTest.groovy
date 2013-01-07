package chapter7

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test
import org.yaml.snakeyaml.Yaml

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.assertThat

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/08
 * Time: 1:28
 * To change this template use File | Settings | File Templates.
 */
class BookStoreYamlTest {

    @Test
    void "total price"() {
        // Setup
        BookStore sut = new BookStore()
        Book book = Book.class.cast new Yaml().load(getClass().getResourceAsStream("book_fixtures.yaml"))
        sut.addToCart(book, 1)

        // Exercise
        // Verify
        assertThat sut.totalPrice, is(4500)
    }

    @Test
    void "get 0"() {
        // Setup
        BookStore sut = new BookStore()
        Book book = Book.class.cast new Yaml().load(getClass().getResourceAsStream("book_fixtures.yaml"))
        sut.addToCart(book, 1)

        // Exercise
        // Verify
        assertThat sut.get(0), is(sameInstance(book))
    }

}
