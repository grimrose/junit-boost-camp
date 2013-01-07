package chapter7

import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

import static chapter7.BookStoreTest.BookStoreTestHelper.Bookオブジェクトの作成_MartinFowlerのRefactoring
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.assertThat

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/08
 * Time: 0:56
 * To change this template use File | Settings | File Templates.
 */
class BookStoreTest {

    @Test
    void "totalPrice"() {
        // Setup
        BookStore sut = new BookStore()
        Book book = Bookオブジェクトの作成_MartinFowlerのRefactoring()
        sut.addToCart(book, 1)
        // Exercise
        // Verify
        assertThat sut.totalPrice, is(4500)
    }

    @Test
    void "get 0"() {
        // Setup
        BookStore sut = new BookStore()
        Book book = Bookオブジェクトの作成_MartinFowlerのRefactoring()
        sut.addToCart(book, 1)
        // Exercise
        // Verify
        assertThat sut.get(0), is(sameInstance(book))
    }

    static class BookStoreTestHelper {
        static Book Bookオブジェクトの作成_MartinFowlerのRefactoring() {
            new Book(
                    title: "Refactoring",
                    price: 4500,
                    author: new Author(
                            firstName: "Martin",
                            lastName: "Fowler"
                    )
            )
        }
    }
}
