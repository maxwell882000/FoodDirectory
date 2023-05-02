

package app.food_directory.data.db.recipes.mapper

import app.food_directory.data.db.recipes.entities.CuisineEntity
import app.food_directory.data.db.recipes.entities.IngredientEntity
import app.food_directory.data.db.recipes.entities.RecipeEntity
import com.elbehiry.model.CuisineItem
import com.elbehiry.model.IngredientItem
import com.elbehiry.model.RecipesItem

const val SEPARATOR = "_"

fun CuisineEntity.toCuisine(): CuisineItem = CuisineItem(
    image = image,
    title = title,
    color = color
)

fun CuisineItem.toCuisineEntity(): CuisineEntity = CuisineEntity(
    image = image,
    title = title,
    color = color
)

fun IngredientEntity.toIngredient(): IngredientItem = IngredientItem(
    id = id,
    image = image,
    title = title,
    background = background
)

fun IngredientItem.toIngredientEntity(): IngredientEntity = IngredientEntity(
    id = id,
    image = image,
    title = title,
    background = background
)

fun RecipesItem.toRecipeEntity() = RecipeEntity(
    id = id,
    title = title,
    sustainable = sustainable,
    glutenFree = glutenFree,
    veryPopular = veryPopular,
    vegetarian = vegetarian,
    dairyFree = dairyFree,
    veryHealthy = veryHealthy,
    vegan = vegan,
    cheap = cheap,
    spoonacularScore = spoonacularScore,
    aggregateLikes = aggregateLikes,
    sourceName = sourceName,
    creditsText = creditsText,
    readyInMinutes = readyInMinutes,
    image = image,
    percentCarbs = percentCarbs,
    percentProtein = percentProtein,
    percentFat = percentFat,
    nutrientsAmount = nutrientsAmount,
    nutrientsName = nutrientsName,
    ingredientOriginalString = ingredientOriginalString?.joinToString(SEPARATOR),
    step = step?.joinToString(SEPARATOR),
)

fun RecipeEntity.toRecipesItem() = RecipesItem(
    id = id,
    title = title,
    sustainable = sustainable,
    glutenFree = glutenFree,
    veryPopular = veryPopular,
    vegetarian = vegetarian,
    dairyFree = dairyFree,
    veryHealthy = veryHealthy,
    vegan = vegan,
    cheap = cheap,
    spoonacularScore = spoonacularScore,
    aggregateLikes = aggregateLikes,
    sourceName = sourceName,
    creditsText = creditsText,
    readyInMinutes = readyInMinutes,
    image = image,
    percentCarbs = percentCarbs,
    percentProtein = percentProtein,
    percentFat = percentFat,
    nutrientsAmount = nutrientsAmount,
    nutrientsName = nutrientsName,
    ingredientOriginalString = ingredientOriginalString?.split(SEPARATOR),
    step = step?.split(SEPARATOR),
    saved = true
    )
