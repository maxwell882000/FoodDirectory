

package com.elbehiry.food_directory.presentation.vm

import app.food_directory.base.vm.MviViewModel
import app.food_directory.domain.usecases.OnBoardingCompletedUseCase
import app.food_directory.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val onBoardingCompletedUseCase: OnBoardingCompletedUseCase
) : MviViewModel<ViewEvent, ViewResult, ViewState, ViewEffect>(ViewState()) {

    init {
        processEvent(ViewEvent.OnBoardingStatus)
    }

    override fun Flow<ViewEvent>.toResults(): Flow<ViewResult> {
        return merge(
            filterIsInstance<ViewEvent.OnBoardingStatus>().onBoardingToMainResult()
        )
    }

    private fun Flow<ViewEvent.OnBoardingStatus>.onBoardingToMainResult(): Flow<ViewResult> {
        return flatMapLatest {
            onBoardingCompletedUseCase(Unit).map { result ->
                delay(1000)
                ViewResult.OnBoardingShown(result.data ?: false)
            }
        }
    }

    override fun ViewResult.reduce(state: ViewState): ViewState {
        return when(this) {
            is ViewResult.OnBoardingShown -> state.copy(
                isOnBoardingShown = isShown
            )
        }
    }
}
