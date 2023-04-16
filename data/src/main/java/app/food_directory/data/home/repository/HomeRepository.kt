package app.food_directory.data.home.repository

import com.elbehiry.model.CuisineItem
import com.elbehiry.model.IngredientItem

interface HomeRepository {
    suspend fun getCuisines(): List<CuisineItem>
    suspend fun getIngredients(): List<IngredientItem>
}
