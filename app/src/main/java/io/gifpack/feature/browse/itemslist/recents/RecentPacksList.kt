package io.gifpack.feature.browse.itemslist.recents

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R

typealias OnRecentPackClick = (Int, Context) -> Unit

@ExperimentalFoundationApi
@Composable
fun RecentPacksList(recents: List<RecentPackItem>, onRecentPackClick: OnRecentPackClick, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.browse_recent_packs_list_items_spacing)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.browse_recent_packs_list_items_spacing)),
        modifier = modifier
            .wrapContentHeight(unbounded = false)
            .heightIn(max = dimensionResource(R.dimen.browse_recent_packs_list_max_height))
    ) {
        items(recents) { pack ->
            RecentPack(pack = pack, onRecentPackClick)
        }
    }
}