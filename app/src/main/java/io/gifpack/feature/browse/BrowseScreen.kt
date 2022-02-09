package io.gifpack.feature.browse

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R
import io.gifpack.feature.browse.header.BrowseHeader

@ExperimentalFoundationApi
@Composable
fun BrowseScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BrowseHeader(
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.browse_list_margin_horizontal),
                    end = dimensionResource(R.dimen.browse_list_margin_horizontal),
                    top = dimensionResource(R.dimen.browse_list_margin_top)
                )
            )
        }
        items(browseScreenContent) { item ->
            BrowseComposableForItemType(item)
        }
    }
}