

package com.elbehiry.food_directory.di

import com.elbehiry.food_directory.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

const val SPOONACULAR_KEY = "SPOONACULAR_KEY"
const val SPOONACULAR_BASE_URL = "SPOONACULAR_BASE_URL"
const val INGREDIENTS_DATA_URL = "INGREDIENTS_DATA_URL"
const val CUISINES_DATA_URL = "CUISINES_DATA_URL"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named(SPOONACULAR_KEY)
    fun provideSpoonCularKey(): String = BuildConfig.SPOONACULAR_KEY

    @Provides
    @Named(SPOONACULAR_BASE_URL)
    fun provideSpoonCularBaseUrlKey(): String = BuildConfig.SPOONACULAR_BASE_URL

    @Provides
    @Named(INGREDIENTS_DATA_URL)
    fun provideIngredientsBaseUrlKey(): String = BuildConfig.INGREDIENTS_DATA_URL

    @Provides
    @Named(CUISINES_DATA_URL)
    fun provideCuisineBaseUrlKey(): String = BuildConfig.CUISINES_DATA_URL

}
