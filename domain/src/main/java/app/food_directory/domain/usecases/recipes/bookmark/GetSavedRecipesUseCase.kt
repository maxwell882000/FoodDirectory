

package app.food_directory.domain.usecases.recipes.bookmark

import androidx.paging.PagingData
import app.food_directory.data.db.recipes.entities.RecipeEntity
import app.food_directory.data.recipes.repository.RecipesRepository
import app.food_directory.domain.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedRecipesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) : UseCase<Unit, Flow<PagingData<RecipeEntity>>>() {

    override fun execute(parameters: Unit): Flow<PagingData<RecipeEntity>> =
        recipesRepository.getRecipes()
}
