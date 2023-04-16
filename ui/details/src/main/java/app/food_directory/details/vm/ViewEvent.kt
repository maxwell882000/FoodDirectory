package app.food_directory.details.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal sealed interface ViewEvent : MviViewModel.MviEvent {
    data class GetRecipe(val recipeId : Int) : ViewEvent
    data class ToggleBookMark(val recipesItem: RecipesItem) : ViewEvent
}
