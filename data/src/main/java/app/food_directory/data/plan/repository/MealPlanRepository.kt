

package app.food_directory.data.plan.repository

import com.elbehiry.model.MealsPlan

interface MealPlanRepository {
    suspend fun getMealsPlan(): MealsPlan
}
