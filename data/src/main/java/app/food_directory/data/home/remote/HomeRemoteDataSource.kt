package app.food_directory.data.home.remote

import app.food_directory.data.remote.DelishApi
import com.elbehiry.model.CuisineItem
import com.elbehiry.model.IngredientItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(
    private val api: DelishApi,
    private val ingredientsUrl: String,
    private val cuisinesUrl: String,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HomeDataSource {

    override suspend fun getAvailableCuisines(): List<CuisineItem> =
        withContext(ioDispatcher) {
            api.getAvailableCuisines(url = cuisinesUrl)
        }

    override suspend fun getIngredients(): List<IngredientItem> =
        withContext(ioDispatcher) {
            api.getIngredients(url = ingredientsUrl)
        }
}
