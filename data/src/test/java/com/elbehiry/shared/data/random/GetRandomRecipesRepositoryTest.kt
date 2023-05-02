

package com.elbehiry.shared.data.random

//import com.elbehiry.model.Recipes
//import com.elbehiry.model.Recipe
//import com.elbehiry.shared.data.recipes.random.remote.RandomRecipesRemoteDataSource
//import com.elbehiry.shared.data.recipes.random.repository.GetRandomRecipesRepository
//import com.elbehiry.test_shared.MainCoroutineRule
//import com.elbehiry.test_shared.runBlockingTest
//import com.github.javafaker.Faker
//import com.nhaarman.mockito_kotlin.anyOrNull
//import com.nhaarman.mockito_kotlin.whenever
//import org.junit.Assert
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class GetRandomRecipesRepositoryTest {
//
//    @get:Rule
//    var coroutineRule = MainCoroutineRule()
//
//    @Mock
//    private lateinit var randomRecipesRemoteDataSource: RandomRecipesRemoteDataSource
//    private lateinit var randomRecipesRepository: GetRandomRecipesRepository
//
//    @Test
//    fun getRandomRecipesTest() {
//        coroutineRule.runBlockingTest {
//            val fakerRecipeItem = Recipe(
//                id = Faker().number().digit().toInt()
//            )
//            val recipe = Recipes(listOf(fakerRecipeItem))
//
//            whenever(randomRecipesRemoteDataSource.getRandomRecipes(anyOrNull(), anyOrNull()))
//                .thenReturn(recipe)
//
//            randomRecipesRepository = GetRandomRecipesRepository(randomRecipesRemoteDataSource)
//            val recipes = randomRecipesRepository.getRandomRecipes(anyOrNull(), anyOrNull())
//            Assert.assertEquals(recipes[0].id, fakerRecipeItem.id)
//        }
//    }
//}
