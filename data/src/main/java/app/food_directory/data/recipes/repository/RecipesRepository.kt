

package app.food_directory.data.recipes.repository

import androidx.paging.PagingData
import app.food_directory.data.db.recipes.entities.RecipeEntity
import com.elbehiry.model.Recipe
import com.elbehiry.model.RecipesItem
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    fun searchRecipes(
        query: String?,
        cuisine: String?
    ): Flow<PagingData<RecipesItem>>

    suspend fun getRecipeInformation(
        id: Int?
    ): RecipesItem

    suspend fun getRandomRecipes(
        tags: String?,
        number: Int?
    ): List<Recipe>

    fun getRecipes(): Flow<PagingData<RecipeEntity>>
    suspend fun deleteRecipe(recipeId: Int?)
    suspend fun isRecipeSaved(parameters: Int?): Boolean
    suspend fun saveRecipe(recipe: RecipesItem)
}
