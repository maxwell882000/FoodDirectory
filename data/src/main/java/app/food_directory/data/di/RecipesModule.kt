

package app.food_directory.data.di

import app.food_directory.data.db.recipes.dao.CuisineDao
import app.food_directory.data.db.recipes.dao.IngredientDao
import app.food_directory.data.db.recipes.dao.RecipesDao
import app.food_directory.data.home.local.HomeLocalDataSource
import app.food_directory.data.home.local.HomeLocalDataSourceImpl
import app.food_directory.data.home.remote.HomeDataSource
import app.food_directory.data.home.remote.HomeRemoteDataSource
import app.food_directory.data.home.repository.HomeRepository
import app.food_directory.data.home.repository.HomeRepositoryImpl
import app.food_directory.data.plan.remote.GetMealPlanRemoteDataSource
import app.food_directory.data.plan.remote.MealPlanDataSource
import app.food_directory.data.plan.repository.GetMealPlanRepository
import app.food_directory.data.plan.repository.MealPlanRepository
import app.food_directory.data.recipes.local.RecipesLocalDataSource
import app.food_directory.data.recipes.local.RecipesLocalDataSourceImpl
import app.food_directory.data.recipes.remote.RecipesDataSource
import app.food_directory.data.recipes.remote.SearchRecipesDataSource
import app.food_directory.data.recipes.repository.RecipesRepository
import app.food_directory.data.recipes.repository.RecipesRepositoryImpl
import app.food_directory.data.remote.DelishApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
class RecipesModule {

    @Provides
    fun provideHomeDataSource(
        api: DelishApi,
        @Named("INGREDIENTS_DATA_URL") ingredientsUrl: String,
        @Named("CUISINES_DATA_URL") cuisinesUrl: String,
    ): HomeDataSource =
        HomeRemoteDataSource(api, ingredientsUrl = ingredientsUrl, cuisinesUrl = cuisinesUrl)

    @Provides
    fun provideHomeLocalDataSource(
        recipesDao: RecipesDao,
        cuisineDao: CuisineDao,
        ingredientDao: IngredientDao
    ): HomeLocalDataSource =
        HomeLocalDataSourceImpl(recipesDao, cuisineDao, ingredientDao)

    @Provides
    fun provideHomeRepository(
        homeDataSource: HomeDataSource,
        homeLocalDataSource: HomeLocalDataSource
    ): HomeRepository =
        HomeRepositoryImpl(homeDataSource, homeLocalDataSource)

    @Provides
    fun provideRecipesDataSource(
        api: DelishApi,
        @Named("SPOONACULAR_KEY") spoonAcularKey: String
    ): RecipesDataSource =
        SearchRecipesDataSource(api, spoonAcularKey = spoonAcularKey)

    @Provides
    fun provideRecipesLocalDataSource(
        recipesTable: RecipesDao
    ): RecipesLocalDataSource =
        RecipesLocalDataSourceImpl(recipesTable = recipesTable)

    @Provides
    fun provideRecipesRepository(
        recipesDataSource: RecipesDataSource,
        recipesLocalDataSource: RecipesLocalDataSource
    ): RecipesRepository =
        RecipesRepositoryImpl(recipesDataSource, recipesLocalDataSource)

    @Provides
    fun provideMealPlanDataSource(
        api: DelishApi, @Named("SPOONACULAR_KEY") spoonAcularKey: String,
    ): MealPlanDataSource =
        GetMealPlanRemoteDataSource(api, spoonAcularKey = spoonAcularKey)

    @Provides
    fun provideMealPlanRepository(
        mealPlanDataSource: MealPlanDataSource
    ): MealPlanRepository =
        GetMealPlanRepository(mealPlanDataSource)
}
