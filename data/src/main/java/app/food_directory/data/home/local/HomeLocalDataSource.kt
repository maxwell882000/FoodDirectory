package app.food_directory.data.home.local

import com.elbehiry.model.CuisineItem
import com.elbehiry.model.IngredientItem

interface HomeLocalDataSource {
    suspend fun saveCuisines(cuisines :List<CuisineItem>)
    suspend fun getCuisines(): List<CuisineItem>
    suspend fun getIngredients(): List<IngredientItem>
    suspend fun saveIngredients(ingredients :List<IngredientItem>)
}
