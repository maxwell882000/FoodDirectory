

package app.food_directory.domain.usecases

import app.food_directory.data.home.repository.HomeRepository
import app.food_directory.domain.SuspendUseCase
import app.food_directory.inject.IoDispatcher
import com.elbehiry.model.IngredientItem
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetIngredientsUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, List<IngredientItem>>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): List<IngredientItem> =
        homeRepository.getIngredients()
}
