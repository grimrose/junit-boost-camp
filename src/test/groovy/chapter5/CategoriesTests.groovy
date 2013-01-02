package chapter5

import org.junit.experimental.categories.Categories
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/03
 * Time: 0:35
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Categories)
@Categories.ExcludeCategory(SlowTests)
@Suite.SuiteClasses(SlowAndFastTest)
class CategoriesTests {

}
