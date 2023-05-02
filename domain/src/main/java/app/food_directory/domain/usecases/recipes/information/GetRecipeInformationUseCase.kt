

package app.food_directory.domain.usecases.recipes.information

import app.food_directory.data.recipes.repository.RecipesRepository
import app.food_directory.domain.SuspendUseCase
import app.food_directory.inject.IoDispatcher
import com.elbehiry.model.RecipesItem
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetRecipeInformationUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Int, RecipesItem>(ioDispatcher) {
    override suspend fun execute(parameters: Int): RecipesItem =
        recipesRepository.getRecipeInformation(parameters)
}
