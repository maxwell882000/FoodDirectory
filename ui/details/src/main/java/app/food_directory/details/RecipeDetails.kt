

package app.food_directory.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import app.food_directory.details.vm.DetailsViewModel
import app.food_directory.details.vm.ViewEvent
import app.food_directory.compose.view.CircularLoading

@Composable
fun DetailsScreen(
    navController: NavController
) {
    DetailsScreen(
        viewModel = hiltViewModel(),
        navController = navController
    )
}

@Composable
internal fun DetailsScreen(
    viewModel: DetailsViewModel,
    navController: NavController
) {

    val viewState by viewModel.states.collectAsStateWithLifecycle()

    CircularLoading(
        isLoading = viewState.isLoading
    ) {
        viewState.recipe?.let { recipe ->
            LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(color = MaterialTheme.colors.background)
        ) {
            item { RecipesHeader(recipe, navController) }
            item {
                RecipeOptions(recipe) { recipe ->
                    recipe.saved = !recipe.saved
                    viewModel.processEvent(ViewEvent.ToggleBookMark(recipe))
                }
            }
            item { RecipeDivider() }
            item { RecipeSummary(recipe) }
            item { RecipeDivider() }
            item { RecipeTags(recipe) }
            item { RecipeCaloric(recipe) }
            item { RecipeDivider() }
            item { RecipeIngredientTitle() }
            items(recipe.ingredientOriginalString ?: listOf()) { recipe ->
                RecipeIngredientItem(recipe)
            }
            item { RecipeDivider() }
//            item { RecipeSteps(recipeDetails.recipe.step) }
            item { Spacer(modifier = Modifier.height(30.dp)) }
        }
        }
    }
}
