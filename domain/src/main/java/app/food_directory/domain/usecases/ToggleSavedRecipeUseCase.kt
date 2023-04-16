package app.food_directory.domain.usecases

import app.food_directory.data.recipes.repository.RecipesRepository
import app.food_directory.domain.SuspendUseCase
import app.food_directory.inject.IoDispatcher
import com.elbehiry.model.RecipesItem
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ToggleSavedRecipeUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<RecipesItem, Unit>(dispatcher) {

    override suspend fun execute(parameters: RecipesItem) {
        if (parameters.saved){
            recipesRepository.saveRecipe(parameters)
        } else{
            recipesRepository.deleteRecipe(parameters.id)
        }
    }
}
