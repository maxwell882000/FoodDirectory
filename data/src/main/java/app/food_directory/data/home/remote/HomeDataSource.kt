package app.food_directory.data.home.remote

import com.elbehiry.model.CuisineItem
import com.elbehiry.model.IngredientItem

interface HomeDataSource {

    suspend fun getAvailableCuisines(): List<CuisineItem>

    suspend fun getIngredients(): List<IngredientItem>
}
