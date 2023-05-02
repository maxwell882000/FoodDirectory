

package app.food_directory.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import app.food_directory.data.db.recipes.dao.CuisineDao
import app.food_directory.data.db.recipes.dao.IngredientDao
import app.food_directory.data.db.recipes.dao.RecipesDao
import app.food_directory.data.db.recipes.entities.CuisineEntity
import app.food_directory.data.db.recipes.entities.IngredientEntity
import app.food_directory.data.db.recipes.entities.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        CuisineEntity::class,
        IngredientEntity::class,
    ],
    version = Constants.VERSION
)
internal abstract class DelishDataBase : RoomDatabase() {
    abstract val recipesTable: RecipesDao
    abstract val cuisineDao : CuisineDao
    abstract val ingredientDao : IngredientDao
}
