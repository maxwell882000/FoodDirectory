

package com.elbehiry.food_directory.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.ViewTreeViewModelStoreOwner
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import app.food_directory.compose.theme.DelishComposeTheme
import com.elbehiry.food_directory.presentation.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private var keepSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().setKeepOnScreenCondition {
            keepSplashScreen
        }

        setContent {
            DelishComposeTheme {
                MainScreen(mainViewModel= mainViewModel){
                    keepSplashScreen = false
                }
            }
        }
        setOwners()
    }
}

private fun ComponentActivity.setOwners() {
    val decorView = window.decorView
    if (ViewTreeLifecycleOwner.get(decorView) == null) {
        ViewTreeLifecycleOwner.set(decorView, this)
    }
    if (ViewTreeViewModelStoreOwner.get(decorView) == null) {
        ViewTreeViewModelStoreOwner.set(decorView, this)
    }
    if (decorView.findViewTreeSavedStateRegistryOwner() == null) {
        decorView.setViewTreeSavedStateRegistryOwner(this)
    }
}

