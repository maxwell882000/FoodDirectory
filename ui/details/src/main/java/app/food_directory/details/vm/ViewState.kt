package app.food_directory.details.vm

import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal data class ViewState(
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val recipe: RecipesItem? = null
) : MviViewModel.MviViewState
