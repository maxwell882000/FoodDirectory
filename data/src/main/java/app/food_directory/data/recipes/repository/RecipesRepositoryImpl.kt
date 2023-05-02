

package app.food_directory.data.recipes.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.food_directory.data.db.recipes.entities.RecipeEntity
import app.food_directory.data.recipes.local.RecipesLocalDataSource
import app.food_directory.data.recipes.remote.RecipesDataSource
import app.food_directory.data.recipes.source.SearchSource
import com.elbehiry.model.Recipe
import com.elbehiry.model.RecipesItem
import com.elbehiry.model.toUiModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val recipesRemoteDataSource: RecipesDataSource,
    private val recipesLocalDataSource: RecipesLocalDataSource
) : RecipesRepository {

    override fun searchRecipes(
        query: String?,
        cuisine: String?
    ): Flow<PagingData<RecipesItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchSource(recipesRemoteDataSource, query, cuisine)
            }
        ).flow
    }

    override suspend fun getRecipeInformation(id: Int?): RecipesItem {
        return recipesLocalDataSource.getRecipeById(id)
            ?: recipesRemoteDataSource.getRecipeInformation(id).toUiModel()
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): List<Recipe> =
        recipesRemoteDataSource.getRandomRecipes(tags, number).recipes

    override fun getRecipes(): Flow<PagingData<RecipeEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory= {
                recipesLocalDataSource.getRecipes()
            }
        ).flow
    }

    override suspend fun deleteRecipe(recipeId: Int?) {
        recipesLocalDataSource.deleteRecipe(recipeId)
    }

    override suspend fun isRecipeSaved(parameters: Int?): Boolean {
        return false
    }

    override suspend fun saveRecipe(recipe: RecipesItem) {
        recipesLocalDataSource.saveRecipe(recipe)
    }
}
