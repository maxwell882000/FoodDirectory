package app.food_directory.search.vm

import androidx.paging.PagingData
import app.food_directory.base.vm.MviViewModel
import com.elbehiry.model.RecipesItem

internal sealed interface ViewResult : MviViewModel.MviViewResult {

    object ErrorResult : ViewResult

    data class SearchResult(
        val searchResult: PagingData<RecipesItem>
    ) : ViewResult
}
