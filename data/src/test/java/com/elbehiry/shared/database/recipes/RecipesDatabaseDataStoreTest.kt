

package com.elbehiry.shared.database.recipes

//import app.cash.turbine.test
//import com.elbehiry.shared.data.db.recipes.recipedatastore.RecipesDatabaseDataStore
//import com.elbehiry.shared.data.db.recipes.tables.RecipesTable
//import com.elbehiry.shared.database.utils.FakeRecipeMapper
//import com.elbehiry.shared.database.utils.RECIPE_ITEM_FAKE
//import com.elbehiry.shared.result.data
//import com.elbehiry.test_shared.MainCoroutineRule
//import com.elbehiry.test_shared.runBlockingTest
//import io.mockk.MockKAnnotations
//import io.mockk.coEvery
//import org.assertj.core.api.Assertions.assertThat
//import kotlinx.coroutines.flow.flowOf
//import io.mockk.impl.annotations.MockK
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import kotlin.time.ExperimentalTime
//
//@ExperimentalTime
//class RecipesDatabaseDataStoreTest {
//
//    @get:Rule
//    var coroutineRule = MainCoroutineRule()
//
//    @MockK
//    private lateinit var recipeTable: RecipesTable
//    private lateinit var recipesDatabaseDataStore: RecipesDatabaseDataStore
//    private lateinit var mapper: FakeRecipeMapper
//
//    @Before
//    fun setup() {
//        MockKAnnotations.init(this, relaxUnitFun = true)
//        mapper = FakeRecipeMapper()
//        recipesDatabaseDataStore = RecipesDatabaseDataStore(
//            recipeTable,
//            mapper,
//            coroutineRule.testDispatcher
//        )
//    }
//
//    @Test
//    fun save_recipe_to_table_successfully() = coroutineRule.runBlockingTest {
//        recipesDatabaseDataStore.saveRecipe(RECIPE_ITEM_FAKE)
//        coEvery {
//            recipeTable.saveRecipe(mapper.mapToDataBaseRecipe(RECIPE_ITEM_FAKE))
//        }
//    }
//
//    @Test
//    fun get_recipes_from_table_successfully() = coroutineRule.runBlockingTest {
//        recipesDatabaseDataStore.saveRecipe(RECIPE_ITEM_FAKE)
//        coEvery { recipeTable.getRecipes() } returns
//            flowOf(listOf(mapper.mapToDataBaseRecipe(RECIPE_ITEM_FAKE)))
//        recipesDatabaseDataStore.getRecipes().test {
//            assertThat(expectItem().data?.size).isNotZero
//            expectComplete()
//        }
//    }
//
//    @Test
//    fun emits_recipes_successfully() = coroutineRule.runBlockingTest {
//        val recipes = listOf(mapper.mapToDataBaseRecipe(RECIPE_ITEM_FAKE))
//        coEvery { recipeTable.getRecipes() } returns flowOf(recipes)
//        recipesDatabaseDataStore.getRecipes().test {
//            assertThat(expectItem().data?.get(0)?.id).isEqualTo(RECIPE_ITEM_FAKE.id)
//            expectComplete()
//        }
//    }
//}
