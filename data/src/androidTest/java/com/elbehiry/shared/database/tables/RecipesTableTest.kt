

package com.elbehiry.shared.database.tables

//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.elbehiry.shared.data.db.DelishDataBase
//import com.elbehiry.shared.data.db.recipes.tables.RecipesTable
//import com.elbehiry.shared.database.utils.RECIPE_FAKE
//import com.elbehiry.shared.database.utils.createMemoryDataBase
//import kotlinx.coroutines.test.runBlockingTest
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.After
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class RecipesTableTest {
//
//    @get:Rule
//    var instantExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var database: DelishDataBase
//    private lateinit var recipeTable: RecipesTable
//
//    @Before
//    fun setup() {
//        database = createMemoryDataBase()
//        recipeTable = database.recipesTable
//    }
//
//    @Test
//    fun save_Recipe_And_Get_Recipe() {
//        runBlockingTest {
//            val recipe = RECIPE_FAKE
//            recipeTable.saveRecipe(recipe)
//            val savedRecipe = recipeTable.getRecipe(recipe.recipeId)
//            assertThat(savedRecipe).isEqualTo(recipe)
//        }
//    }
//
//    @After
//    fun cleanUp() {
//        database.close()
//    }
//}
