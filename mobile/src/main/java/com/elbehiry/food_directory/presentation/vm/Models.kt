package com.elbehiry.food_directory.presentation.vm

import app.food_directory.base.vm.MviViewModel.MviEvent
import app.food_directory.base.vm.MviViewModel.MviSideEffect
import app.food_directory.base.vm.MviViewModel.MviViewState
import app.food_directory.base.vm.MviViewModel.MviViewResult

internal sealed interface ViewEvent : MviEvent {
    object OnBoardingStatus : ViewEvent
}

internal interface ViewEffect : MviSideEffect

internal data class ViewState(
    val isOnBoardingShown : Boolean? = null
) : MviViewState


internal sealed interface ViewResult : MviViewResult {
    data class OnBoardingShown(val isShown: Boolean) : ViewResult
}
