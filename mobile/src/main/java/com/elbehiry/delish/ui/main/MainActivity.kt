package com.elbehiry.delish.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.setContent
import com.elbehiry.delish.ui.graph.NavGraph
import com.elbehiry.delish.ui.theme.DelishComposeTheme
import com.elbehiry.delish.ui.util.AmbientBackDispatcher
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets


fun launchMainActivity(context: Context) {
    context.startActivity(Intent(context, MainActivity::class.java))
}

class MainActivity : ComponentActivity() {

    @SuppressLint("VisibleForTests")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DelishComposeTheme {
                Providers(AmbientBackDispatcher provides onBackPressedDispatcher) {
                    ProvideWindowInsets {
                        NavGraph()
                    }
                }
            }
        }
    }
}