package chapter5

import org.junit.experimental.categories.Categories
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Categories)
@Categories.ExcludeCategory(SlowTests)
@Suite.SuiteClasses(SlowAndFastTest)
class CategoriesTests {

}
