

package app.food_directory.domain.usecases.plan

import app.food_directory.inject.IoDispatcher
import app.food_directory.data.plan.repository.GetMealPlanRepository
import app.food_directory.domain.SuspendUseCase
import com.elbehiry.model.DayMeal
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetMealPlanUseCase @Inject constructor(
    private val getMealPlanRepository: GetMealPlanRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, List<DayMeal?>>(ioDispatcher) {
    override suspend fun execute(parameters: Unit): List<DayMeal?> {
        val mealPlan = getMealPlanRepository.getMealsPlan().week
        return listOf(
            mealPlan?.saturday,
            mealPlan?.sunday,
            mealPlan?.monday,
            mealPlan?.tuesday,
            mealPlan?.wednesday,
            mealPlan?.thursday,
            mealPlan?.friday
        )
    }
}
