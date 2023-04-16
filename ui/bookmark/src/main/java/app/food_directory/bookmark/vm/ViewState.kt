package app.food_directory.bookmark.vm

import androidx.paging.PagingData
import app.food_directory.base.vm.MviViewModel
import app.food_directory.data.db.recipes.entities.RecipeEntity

internal data class ViewState(
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val savedRecipes: PagingData<RecipeEntity> = PagingData.empty()
) : MviViewModel.MviViewState
