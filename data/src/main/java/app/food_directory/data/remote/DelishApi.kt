

package app.food_directory.data.remote

import com.elbehiry.model.CuisineItem
import com.elbehiry.model.Recipes
import com.elbehiry.model.IngredientItem
import com.elbehiry.model.Recipe
import com.elbehiry.model.SearchItem
import com.elbehiry.model.MealsPlan
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface DelishApi {

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("apiKey") apiKey: String,
        @Query("tags") tags: String?,
        @Query("number") number: Int?
    ): Recipes

    @GET
    suspend fun getAvailableCuisines(@Url url : String): List<CuisineItem>

    @GET
    suspend fun getIngredients(@Url url : String): List<IngredientItem>

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int?,
        @Query("apiKey") apiKey: String,
        @Query("includeNutrition") includeNutrition: Boolean? = true
    ): Recipe

    @GET("/recipes/complexSearch")
    @Suppress("LongParameterList")
    suspend fun searchRecipes(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String?,
        @Query("cuisine") cuisine: String?,
        @Query("addRecipeInformation") addRecipeInformation: Boolean?,
        @Query("number") number: Int?,
        @Query("offset") offset: Int
    ): SearchItem

    @GET("/mealplanner/generate")
    suspend fun getMealsPlan(
        @Query("apiKey") apiKey: String,
        @Query("timeFrame") timeFrame: String = "week"
    ): MealsPlan
}
