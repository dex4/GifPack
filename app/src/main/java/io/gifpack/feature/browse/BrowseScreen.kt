package io.gifpack.feature.browse

import android.content.Context
import android.widget.Toast
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
import io.gifpack.feature.browse.header.BrowseHeader
import io.gifpack.feature.browse.header.OnActionsMenuItemClick
import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.feature.browse.packslist.PacksList
import io.gifpack.feature.browse.recents.RecentPacksList
import io.gifpack.feature.browse.sectionheader.SectionHeader
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun BrowseScreen(onActionsMenuItemClick: OnActionsMenuItemClick) {

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
            item {
                BrowseHeader(
                    true,
                    { route -> onActionsMenuItemClick(route) },
                    { route -> onActionsMenuItemClick(route) },
                    { route -> onActionsMenuItemClick(route) },
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

        val isButtonVisible = browseListState.firstVisibleItemIndex > 1

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

private fun onGifPackClick(packId: Int, context: Context) {
    Toast.makeText(context, packId.toString(), Toast.LENGTH_SHORT).show()
}

private fun onRecentPackClick(packId: Int, context: Context) {
    Toast.makeText(context, packId.toString(), Toast.LENGTH_SHORT).show()
}