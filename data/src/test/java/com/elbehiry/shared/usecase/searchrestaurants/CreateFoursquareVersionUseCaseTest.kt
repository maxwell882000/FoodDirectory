

package com.elbehiry.shared.usecase.searchrestaurants

import app.food_directory.domain.usecases.restaurants.CreateFoursquareVersionUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.Calendar

class CreateFoursquareVersionUseCaseTest {

    lateinit var usecase: app.food_directory.domain.usecases.restaurants.CreateFoursquareVersionUseCase

    @Before
    fun setup() {
        usecase = app.food_directory.domain.usecases.restaurants.CreateFoursquareVersionUseCase()
    }

    @Test
    fun `test format the current date to foursquare version format`() {

        val year = 1993
        val month = 12
        val day = 15

        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, Calendar.DECEMBER)
            set(Calendar.DAY_OF_MONTH, day)
        }
        val expectationItem = "$year$month$day"
        val result = usecase(calendar.time)

        Assert.assertEquals(expectationItem, result)
    }
}
