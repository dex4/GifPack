package io.gifpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.gifpack.feature.browse.browseScreenContent
import io.gifpack.feature.browse.header.BrowseHeader
import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.feature.browse.recentPacks
import io.gifpack.feature.browse.recents.RecentPacks
import io.gifpack.feature.browse.recommendedsection.PacksList
import io.gifpack.feature.browse.recommendedsection.SectionHeader
import io.gifpack.ui.theme.GifPackTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GifPackTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        item {
                            BrowseHeader(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp))
                        }
                        items(browseScreenContent) { item ->
                            when (item) {
                                is BrowseListItem.RecentPacksList -> RecentPacks(
                                    recentPacks,
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 8.dp)
                                )
                                is BrowseListItem.SectionHeader -> SectionHeader(
                                    sectionHeaderData = item.sectionHeaderData,
                                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp)
                                )
                                is BrowseListItem.GifPacksList -> PacksList(
                                    packs = item.gifPacks,
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }
                        }
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
                Row { RecentPacks(recentPacks) }
            }
        }
    }
}