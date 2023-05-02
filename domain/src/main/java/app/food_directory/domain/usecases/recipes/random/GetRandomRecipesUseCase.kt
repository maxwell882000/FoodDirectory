

package app.food_directory.domain.usecases.recipes.random

import app.food_directory.data.recipes.repository.RecipesRepository
import app.food_directory.domain.UseCase
import app.food_directory.result.Result
import com.elbehiry.model.RecipesItem
import com.elbehiry.model.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val DEFAULT_NUMBER = 10

class GetRandomRecipesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) : UseCase<GetRandomRecipesUseCase.Params, Flow<Result<List<RecipesItem>>>>() {

    @Suppress("TooGenericExceptionCaught")
    override fun execute(parameters: Params): Flow<Result<List<RecipesItem>>> =
        flow {
            try {
                val randomRecipes = recipesRepository.getRandomRecipes(
                    parameters.tags, parameters.number
                ).map {
                    it.toUiModel()
                }
                emit(Result.Success(randomRecipes))
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }

    class Params private constructor(
        val tags: String?,
        val number: Int? = DEFAULT_NUMBER

    ) {

        companion object {
            @JvmStatic
            fun create(tags: String?, number: Int?): Params {
                return Params(tags, number)
            }
        }
    }
}
