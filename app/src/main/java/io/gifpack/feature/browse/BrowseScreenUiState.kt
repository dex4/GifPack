package io.gifpack.feature.browse

import io.gifpack.feature.browse.itemslist.model.BrowseListItem

sealed class BrowseScreenUiState {

    data class Ready(
        val browseScreenData: List<BrowseListItem>
    ) : BrowseScreenUiState()

    object Loading : BrowseScreenUiState()

    object Error : BrowseScreenUiState()
}
