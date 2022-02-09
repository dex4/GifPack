package io.gifpack.feature.browse

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R
import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.feature.browse.packslist.PacksList
import io.gifpack.feature.browse.recents.RecentPacksList
import io.gifpack.feature.browse.sectionheader.SectionHeader

@ExperimentalFoundationApi
@Composable
fun BrowseComposableForItemType(item: BrowseListItem) {
    when (item) {
        is BrowseListItem.RecentPacksList -> RecentPacksList(
            recentPacks,
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
            modifier = Modifier.padding(top = dimensionResource(R.dimen.browse_list_items_spacing_vertical))
        )
    }
}