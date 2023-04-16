package app.food_directory.bookmark.vm

import androidx.paging.PagingData
import app.food_directory.base.vm.MviViewModel
import app.food_directory.data.db.recipes.entities.RecipeEntity

internal sealed interface ViewResult : MviViewModel.MviViewResult {

    object ErrorResult : ViewResult

    data class SavedRecipes(
        val savedRecipes: PagingData<RecipeEntity>
    ) : ViewResult

    object NoOpResult : ViewResult
}
