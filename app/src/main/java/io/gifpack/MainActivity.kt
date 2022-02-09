package io.gifpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.gifpack.feature.browse.BrowseScreen
import io.gifpack.ui.theme.GifPackTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GifPackTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BrowseScreen()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GifPackTheme {
        Surface(color = MaterialTheme.colors.background) {
            BrowseScreen()
        }
    }
}