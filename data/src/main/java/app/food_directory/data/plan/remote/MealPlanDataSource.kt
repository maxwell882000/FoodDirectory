

package app.food_directory.data.plan.remote

import com.elbehiry.model.MealsPlan

interface MealPlanDataSource {
    suspend fun getMealsPlan(): MealsPlan
}
