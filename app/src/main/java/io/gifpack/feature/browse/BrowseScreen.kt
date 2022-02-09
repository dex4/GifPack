package io.gifpack.feature.browse

import android.content.Context
import android.widget.Toast
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
import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.feature.browse.packslist.PacksList
import io.gifpack.feature.browse.recents.RecentPacksList
import io.gifpack.feature.browse.sectionheader.SectionHeader

@ExperimentalFoundationApi
@Composable
fun BrowseScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BrowseHeader(
                true,
                ::onActionMenuItemClicked,
                ::onActionMenuItemClicked,
                ::onActionMenuItemClicked,
                Modifier.padding(
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

@ExperimentalFoundationApi
@Composable
fun BrowseComposableForItemType(item: BrowseListItem) {
    when (item) {
        is BrowseListItem.RecentPacksList -> RecentPacksList(
            recentPacks,
            ::onRecentPackClick,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.browse_list_margin_horizontal),
                end = dimensionResource(R.dimen.browse_list_margin_horizontal),
                top = dimensionResource(R.dimen.browse_list_items_spacing_vertical),
                bottom = dimensionResource(R.dimen.browse_list_items_spacing_vertical)
            )
        )
        is BrowseListItem.SectionHeader -> SectionHeader(
            sectionHeaderData = item.sectionHeaderData,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.browse_list_margin_horizontal),
                end = dimensionResource(R.dimen.browse_list_margin_horizontal),
                top = dimensionResource(R.dimen.browse_list_items_spacing_vertical)
            )
        )
        is BrowseListItem.GifPacksList -> PacksList(
            packs = item.gifPacks,
            ::onGifPackClick,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.browse_list_items_spacing_vertical))
        )
    }
}

private fun onActionMenuItemClicked(itemName: String, context: Context) {
    Toast.makeText(context, itemName, Toast.LENGTH_SHORT).show()
}

private fun onGifPackClick(packId: Int, context: Context) {
    Toast.makeText(context, packId.toString(), Toast.LENGTH_SHORT).show()
}

private fun onRecentPackClick(packId: Int, context: Context) {
    Toast.makeText(context, packId.toString(), Toast.LENGTH_SHORT).show()
}