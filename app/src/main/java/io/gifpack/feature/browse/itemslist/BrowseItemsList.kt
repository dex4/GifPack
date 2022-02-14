package io.gifpack.feature.browse.itemslist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import coil.compose.rememberImagePainter
import io.gifpack.R
import io.gifpack.feature.browse.itemslist.model.BrowseListItem
import io.gifpack.feature.browse.itemslist.packslist.OnGifPackClick
import io.gifpack.feature.browse.itemslist.packslist.PacksList
import io.gifpack.feature.browse.itemslist.recents.OnRecentPackClick
import io.gifpack.feature.browse.itemslist.recents.RecentPacksList
import io.gifpack.feature.browse.itemslist.sectionheader.SectionHeader
import io.gifpack.feature.browse.recentPacks
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun BrowseItemsList(browseScreenItemsList: List<BrowseListItem>, onGifPackClick: OnGifPackClick, onRecentPackClick: OnRecentPackClick) {
    Box {
        val browseListState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                bottom = dimensionResource(R.dimen.browse_scroll_to_top_button_size) +
                        dimensionResource(R.dimen.browse_scroll_to_top_button_spacing_bottom)
            ),
            state = browseListState
        ) {
            items(browseScreenItemsList) { item ->
                BrowseComposableForItemType(item, onGifPackClick, onRecentPackClick)
            }
        }

        val isButtonVisible = browseListState.firstVisibleItemIndex > 0

        AnimatedVisibility(
            visible = isButtonVisible,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(dimensionResource(R.dimen.browse_scroll_to_top_button_spacing_bottom))
                .clip(CircleShape)
                .size(dimensionResource(R.dimen.browse_scroll_to_top_button_size))
        ) {
            FloatingActionButton(
                onClick = { coroutineScope.launch { browseListState.animateScrollToItem(0) } },
                backgroundColor = MaterialTheme.colors.primaryVariant
            ) {
                Image(
                    painter = rememberImagePainter(R.drawable.ic_direction_indicator_up),
                    contentDescription = null
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun BrowseComposableForItemType(item: BrowseListItem, onGifPackClick: OnGifPackClick, onRecentPackClick: OnRecentPackClick) {
    when (item) {
        is BrowseListItem.RecentPacksList -> RecentPacksList(
            recentPacks,
            { packId, context -> onRecentPackClick(packId, context) },
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
            { packId, context -> onGifPackClick(packId, context) },
            modifier = Modifier.padding(top = dimensionResource(R.dimen.browse_list_items_spacing_vertical))
        )
    }
}