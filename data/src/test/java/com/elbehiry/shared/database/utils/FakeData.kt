

package com.elbehiry.shared.database.utils

import com.elbehiry.model.RecipesItem
import com.github.javafaker.Faker

private val faker: Faker by lazy {
    Faker()
}

internal val RECIPE_ITEM_FAKE = RecipesItem(
    id = faker.number().digit().toInt(),
    title = faker.lorem().sentence(),
    sustainable = false,
    glutenFree = false,
    veryPopular = false,
    vegetarian = false,
    dairyFree = false,
    veryHealthy = false,
    vegan = false,
    cheap = false,
    spoonacularScore = faker.number().digit().toDouble(),
    aggregateLikes = faker.number().digit().toInt(),
    sourceName = faker.lorem().word(),
    creditsText = faker.lorem().sentence(),
    readyInMinutes = faker.number().digit().toInt(),
    image = faker.internet().image(),
    percentCarbs = faker.number().digit().toDouble(),
    percentProtein = faker.number().digit().toDouble(),
    percentFat = faker.number().digit().toDouble(),
    nutrientsAmount = faker.number().digit().toDouble(),
    nutrientsName = faker.lorem().word(),
    ingredientOriginalString = emptyList(),
    healthScore = faker.number().digit().toDouble(),
    step = emptyList()
)
