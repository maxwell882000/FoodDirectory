

package app.food_directory.data.recipes.remote

import app.food_directory.data.remote.DelishApi
import com.elbehiry.model.Recipe
import com.elbehiry.model.Recipes
import com.elbehiry.model.SearchItem

const val DEFAULT_NUMBER = 20
const val DEFAULT_RECIPE_INFORMATION = false

class SearchRecipesDataSource(
    private val api: DelishApi,
    private val spoonAcularKey: String
) : RecipesDataSource {

    override suspend fun getRecipeInformation(id: Int?): Recipe =
        api.getRecipeInformation(id = id, apiKey = spoonAcularKey)

    override suspend fun searchRecipes(
        query: String?,
        cuisine: String?,
        offset: Int
    ): SearchItem = api.searchRecipes(
        query = query,
        cuisine = cuisine,
        addRecipeInformation = DEFAULT_RECIPE_INFORMATION,
        number = DEFAULT_NUMBER,
        offset = offset,
        apiKey = spoonAcularKey
    )

    override suspend fun getRandomRecipes(
        tags: String?,
        number: Int?
    ): Recipes = api.getRandomRecipes(tags = tags, number = number, apiKey = spoonAcularKey)
}
