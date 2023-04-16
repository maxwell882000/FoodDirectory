package app.food_directory.discover.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.IngredientItem

internal interface ViewEffect : MviViewModel.MviSideEffect {
    data class OpenIngredientsSheet(val ingredients : List<IngredientItem>) : ViewEffect
}
