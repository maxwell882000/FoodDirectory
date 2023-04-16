package app.food_directory.discover.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.CuisineItem
import com.elbehiry.model.IngredientItem
import com.elbehiry.model.RecipesItem

internal sealed interface ViewResult : MviViewModel.MviViewResult {

    object ErrorResult : ViewResult

    data class HomeContent(
        val ingredientList: List<IngredientItem> = emptyList(),
        val cuisinesList: List<CuisineItem> = emptyList(),
        val randomRecipes: List<RecipesItem> = emptyList()
    ) : ViewResult

    data class OnIngredientsSheet(val ingredientList: List<IngredientItem>) : ViewResult

    object NoOpResult : ViewResult
}
