package app.food_directory.bookmark.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal sealed interface ViewEvent : MviViewModel.MviEvent {
    object GetSavedRecipes : ViewEvent
    data class ToggleBookMark(val recipesItem: RecipesItem) : ViewEvent
}
