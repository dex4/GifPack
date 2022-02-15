package io.gifpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.gifpack.feature.browse.BrowseScreen
import io.gifpack.feature.browse.BrowseViewModel
import io.gifpack.feature.notifications.NotificationsScreen
import io.gifpack.feature.settings.SettingsScreen
import io.gifpack.feature.sharedhistory.SharedHistoryScreen
import io.gifpack.ui.theme.GifPackTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GifPackTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "BrowseScreen") {
                        composable("BrowseScreen") {
                            val browseViewModel = hiltViewModel<BrowseViewModel>()
                            BrowseScreen(browseViewModel) { route -> navController.navigate(route) }
                        }
                        composable("NotificationsScreen") { NotificationsScreen() }
                        composable("SharedHistoryScreen") { SharedHistoryScreen() }
                        composable("SettingsScreen") { SettingsScreen() }
                    }
                }
            }
        }
    }
}