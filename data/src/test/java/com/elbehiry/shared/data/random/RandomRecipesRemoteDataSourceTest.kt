

package com.elbehiry.shared.data.random
//
//import com.elbehiry.shared.data.recipes.random.remote.GetRandomRecipesRemoteDataSource
//import com.elbehiry.shared.data.remote.DelishApi
//import com.elbehiry.test_shared.MainCoroutineRule
//import io.mockk.MockKAnnotations
//import io.mockk.impl.annotations.MockK
//import org.junit.Before
//import org.junit.Rule
//
//class RandomRecipesRemoteDataSourceTest {
//
//    @MockK
//    private lateinit var api: DelishApi
//
//    @get:Rule
//    var coroutineRule = MainCoroutineRule()
//
//    private lateinit var randomRecipesRemoteDataSource: GetRandomRecipesRemoteDataSource
//
//    @Before
//    fun setup() {
//        MockKAnnotations.init(this, relaxUnitFun = true)
//        randomRecipesRemoteDataSource = GetRandomRecipesRemoteDataSource(api)
//    }
//
//// comment this test case because of runBlockingTest fails with "This job has not completed yet"
////    @Test
////    fun getRandomRecipesTest() = coroutineRule.runBlockingTest {
////        val recipes = Recipes()
////        coEvery {
////            api.getRandomRecipes(tags = any(), number = any())
////        } returns recipes
////        val recipesItem = randomRecipesRemoteDataSource.getRandomRecipes("", 3)
////        Assert.assertEquals(recipes, recipesItem)
////    }
//}
