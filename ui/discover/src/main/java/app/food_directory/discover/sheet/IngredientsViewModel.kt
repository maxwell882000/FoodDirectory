package app.food_directory.discover.sheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.food_directory.domain.usecases.GetIngredientsUseCase
import app.food_directory.result.data
import com.elbehiry.model.IngredientItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class IngredientsViewModel @Inject constructor(
    private val getIngredientsUseCase: GetIngredientsUseCase
): ViewModel(){

    private val _currentIngredients = MutableStateFlow<List<IngredientItem>>(emptyList())
    val currentIngredients: StateFlow<List<IngredientItem>> = _currentIngredients

    init {
        viewModelScope.launch {
            _currentIngredients.emit(getIngredientsUseCase(Unit).data?.shuffled() ?: emptyList())
        }
    }
}
