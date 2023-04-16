package app.food_directory.discover.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal sealed interface ViewEvent : MviViewModel.MviEvent {
    object GetHomeContent : ViewEvent
    data class ToggleBookMark(val recipesItem: RecipesItem) : ViewEvent
    object OpenIngredients : ViewEvent
}
