package app.food_directory.discover.vm

import app.food_directory.base.vm.MviViewModel
import app.food_directory.domain.usecases.GetAvailableCuisinesUseCase
import app.food_directory.domain.usecases.GetIngredientsUseCase
import app.food_directory.domain.usecases.recipes.random.GetRandomRecipesUseCase
import app.food_directory.result.Result
import app.food_directory.result.data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.combine
import app.food_directory.discover.vm.ViewEvent.ToggleBookMark
import app.food_directory.discover.vm.ViewEvent.OpenIngredients
import app.food_directory.discover.vm.ViewEvent.GetHomeContent
import app.food_directory.discover.vm.ViewEffect.OpenIngredientsSheet
import app.food_directory.discover.vm.ViewResult.ErrorResult
import app.food_directory.discover.vm.ViewResult.HomeContent
import app.food_directory.discover.vm.ViewResult.NoOpResult
import app.food_directory.discover.vm.ViewResult.OnIngredientsSheet
import app.food_directory.domain.usecases.ToggleSavedRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val RANDOM_RECIPES_COUNT = 20

@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase,
    private val getAvailableCuisinesUseCase: GetAvailableCuisinesUseCase,
    private val toggleSavedRecipeUseCase: ToggleSavedRecipeUseCase,
    private val getIngredientsUseCase: GetIngredientsUseCase
) : MviViewModel<ViewEvent, ViewResult, ViewState, ViewEffect>(ViewState()) {

    init {
        processEvent(GetHomeContent)
    }

    override fun Flow<ViewEvent>.toResults(): Flow<ViewResult> {
        return merge(
            filterIsInstance<GetHomeContent>().toGetHomeContentResult(),
            filterIsInstance<ToggleBookMark>().toToggleBookMarkResult(),
            filterIsInstance<OpenIngredients>().toOpenIngredientsResult(),
        )
    }

    override fun ViewResult.reduce(state: ViewState): ViewState {
        return when (this) {
            is ErrorResult -> state.copy(isLoading = false, hasError = true)
            is HomeContent -> state.copy(
                isLoading = false,
                hasError = false,
                ingredientList = ingredientList,
                cuisinesList = cuisinesList,
                randomRecipes = randomRecipes
            )
            else -> state
        }
    }

    override fun Flow<ViewResult>.toEffects(): Flow<ViewEffect> {
        return merge(
            filterIsInstance<OnIngredientsSheet>().toOnIngredientsSheetEffects()
        )
    }

    private fun Flow<GetHomeContent>.toGetHomeContentResult(): Flow<ViewResult> {
        return flatMapLatest {
            combine(
                getRandomRecipesUseCase(
                    GetRandomRecipesUseCase.Params.create(
                        null,
                        RANDOM_RECIPES_COUNT
                    )
                ),
                flowOf(getIngredientsUseCase(Unit)),
                flowOf(getAvailableCuisinesUseCase(Unit))
            ) { randomRecipes, ingredients, cuisines ->
                if (cuisines is Result.Error || ingredients is Result.Error) {
                    ErrorResult
                } else {
                    HomeContent(
                        ingredientList = ingredients.data?.shuffled()?.take(8) ?: emptyList(),
                        cuisinesList = cuisines.data ?: emptyList(),
                        randomRecipes = randomRecipes.data ?: emptyList()
                    )
                }
            }
        }
    }

    private fun Flow<ToggleBookMark>.toToggleBookMarkResult(): Flow<ViewResult> {
        return mapLatest {
            toggleSavedRecipeUseCase(it.recipesItem)
            NoOpResult
        }
    }

    private fun Flow<OpenIngredients>.toOpenIngredientsResult(): Flow<ViewResult> {
        return mapLatest {
            OnIngredientsSheet(states.value.ingredientList)
        }
    }

    private fun Flow<OnIngredientsSheet>.toOnIngredientsSheetEffects(): Flow<ViewEffect> {
        return mapLatest { result -> OpenIngredientsSheet(result.ingredientList) }
    }
}
