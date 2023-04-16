package app.food_directory.details.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal sealed interface ViewResult : MviViewModel.MviViewResult {

    object ErrorResult : ViewResult

    data class RecipeItem(
        val recipe: RecipesItem? = null
    ) : ViewResult

    object NoOpResult : ViewResult
}
