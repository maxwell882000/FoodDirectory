

package app.food_directory.data.plan.remote

import com.elbehiry.model.MealsPlan
import app.food_directory.data.remote.DelishApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealPlanRemoteDataSource @Inject constructor(
    private val api: DelishApi,
    private val spoonAcularKey: String,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MealPlanDataSource {
    override suspend fun getMealsPlan(): MealsPlan =
        withContext(ioDispatcher) {
            api.getMealsPlan(apiKey = spoonAcularKey)
        }
}
