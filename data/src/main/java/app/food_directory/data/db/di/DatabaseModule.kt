

package app.food_directory.data.db.di

import android.content.Context
import androidx.room.Room
import app.food_directory.data.db.Constants
import app.food_directory.data.db.DelishDataBase
import app.food_directory.data.db.JsonConverter
import app.food_directory.data.db.MIGRATIONS
import app.food_directory.data.db.recipes.dao.CuisineDao
import app.food_directory.data.db.recipes.dao.IngredientDao
import app.food_directory.data.db.recipes.dao.RecipesDao
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    @Suppress("SpreadOperator")
    fun provideDelishDatabase(@ApplicationContext context: Context): DelishDataBase {
        return Room.databaseBuilder(
            context,
            DelishDataBase::class.java,
            Constants.DATABASE_NAME
        ).addMigrations(*MIGRATIONS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRecipesTable(delishDataBase: DelishDataBase): RecipesDao {
        return delishDataBase.recipesTable
    }

    @Provides
    @Singleton
    fun provideCuisineDao(food_directoryDataBase: DelishDataBase): CuisineDao {
        return food_directoryDataBase.cuisineDao
    }

    @Provides
    @Singleton
    fun provideIngredientDao(food_directoryDataBase: DelishDataBase): IngredientDao {
        return food_directoryDataBase.ingredientDao
    }

    @Provides
    @Singleton
    fun provideJsonConverter(moshi: Moshi): JsonConverter = JsonConverter(moshi)
}
