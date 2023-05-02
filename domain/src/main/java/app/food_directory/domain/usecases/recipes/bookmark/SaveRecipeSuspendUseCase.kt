

package app.food_directory.domain.usecases.recipes.bookmark

import app.food_directory.data.recipes.repository.RecipesRepository
import app.food_directory.domain.SuspendUseCase
import app.food_directory.inject.IoDispatcher
import com.elbehiry.model.RecipesItem
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveRecipeSuspendUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<RecipesItem, Unit>(ioDispatcher) {
    override suspend fun execute(
        parameters: RecipesItem
    ) = recipesRepository.saveRecipe(parameters)
}
