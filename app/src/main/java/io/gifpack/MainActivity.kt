package io.gifpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.gifpack.feature.browse.fromSoftwarePacks
import io.gifpack.feature.browse.header.BrowseHeader
import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.feature.browse.recentPacks
import io.gifpack.feature.browse.recents.RecentPackItem
import io.gifpack.feature.browse.recents.RecentPacksGrid
import io.gifpack.feature.browse.recommendedsection.PackList
import io.gifpack.feature.browse.recommendedsection.SectionHeader
import io.gifpack.ui.theme.GifPackTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GifPackTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Column {
                        BrowseHeader(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                        SectionHeader(
                            sectionHeader = BrowseListItem.SectionHeader(0, "Recents"),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                        RecentPacksGrid(recentPacks, modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                        SectionHeader(
                            sectionHeader = BrowseListItem.SectionHeader(
                                1,
                                "From Software",
                                "For fans of",
                                "https://picsum.photos/id/92/200/200",
                            ),
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                        PackList(packs = fromSoftwarePacks, modifier = Modifier.padding(top = 12.dp))
                    }
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
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Column {
                Row { BrowseHeader() }
                Row { RecentPacksGrid(recentPacks) }
            }
        }
    }
}