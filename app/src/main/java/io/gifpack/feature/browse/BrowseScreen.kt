package io.gifpack.feature.browse

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import io.gifpack.R
import io.gifpack.feature.browse.itemslist.BrowseItemsList
import io.gifpack.feature.browse.itemslist.header.BrowseHeader
import io.gifpack.feature.browse.itemslist.header.OnActionsMenuItemClick
import io.gifpack.util.ui.ContentLoadingIndicator
import io.gifpack.util.ui.ErrorScreen

@ExperimentalFoundationApi
@Composable
fun BrowseScreen(
    browseViewModel: BrowseViewModel = viewModel(),
    onActionsMenuItemClick: OnActionsMenuItemClick
) {
    val browseScreenUiState = browseViewModel.browseScreenUiState.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BrowseHeader(
            true,
            { route -> onActionsMenuItemClick(route) },
            Modifier.padding(
                start = dimensionResource(R.dimen.browse_list_margin_horizontal),
                end = dimensionResource(R.dimen.browse_list_margin_horizontal),
                top = dimensionResource(R.dimen.browse_list_margin_top),
                bottom = dimensionResource(R.dimen.browse_list_margin_bottom)
            )
        )
        when (val state = browseScreenUiState.value) {
            is BrowseScreenUiState.Ready -> BrowseItemsList(state.browseScreenData, ::onGifPackClick, ::onRecentPackClick)
            is BrowseScreenUiState.Loading -> ContentLoadingIndicator(Modifier.fillMaxHeight())
            else -> ErrorScreen(
                titleText = stringResource(R.string.browse_error_state_title),
                descriptionText = stringResource(R.string.browse_error_state_description),
                actionButtonText = stringResource(R.string.browse_error_state_button_text),
                modifier = Modifier.fillMaxHeight(),
                onActionButtonClick = { browseViewModel.getBroseScreenData() }
            )
        }
    }
}

private fun onGifPackClick(packId: Int, context: Context) {
    Toast.makeText(context, packId.toString(), Toast.LENGTH_SHORT).show()
}

private fun onRecentPackClick(packId: Int, context: Context) {
    Toast.makeText(context, packId.toString(), Toast.LENGTH_SHORT).show()
}