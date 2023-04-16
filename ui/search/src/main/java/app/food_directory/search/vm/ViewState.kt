package app.food_directory.search.vm

import androidx.paging.PagingData
import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal data class ViewState(
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val searchResult: PagingData<RecipesItem> = PagingData.empty()
) : MviViewModel.MviViewState
