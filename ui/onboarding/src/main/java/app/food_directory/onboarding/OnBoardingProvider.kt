

package app.food_directory.onboarding

import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import app.food_directory.onboarding.R

internal object OnBoardingProvider {
    val onBoardingItems by lazy {
        listOf(
            OnboardingPage.Page1,
            OnboardingPage.Page2,
            OnboardingPage.Page3
        )
    }

}

private val PurpleOnBoarding = Color(0xFFFFAE4E)
private val OrangeOnBoarding = Color(0xFFFFBE96)
private val BlueOnBoardingLight = Color(0xFF1EB091)

sealed class OnboardingPage(
    @StringRes val title: Int,
    @StringRes val subtitle: Int,
    @RawRes val animation: Int,
    val color: Color
) {
    object Page1 : OnboardingPage(
        R.string.label_title_onboarding1,
        R.string.label_subtitle_onboarding1,
        R.raw.onboarding_page_one,
        PurpleOnBoarding
    )

    object Page2 : OnboardingPage(
        R.string.label_title_onboarding2,
        R.string.label_subtitle_onboarding2,
        R.raw.onboarding_page_two,
        OrangeOnBoarding
    )

    object Page3 : OnboardingPage(
        R.string.label_title_onboarding3,
        R.string.label_subtitle_onboarding3,
        R.raw.onboarding_page_three,
        BlueOnBoardingLight
    )
}
