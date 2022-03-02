package io.gifpack.feature.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.gifpack.core.GetGifPacksSuggestionsUseCase
import io.gifpack.core.GetRecentPacksUseCase
import io.gifpack.feature.browse.itemslist.model.BrowseListItem
import io.gifpack.feature.browse.itemslist.model.mapToSuggestedSections
import io.gifpack.feature.browse.itemslist.model.toRecentsSection
import kotlinx.coroutines.launch

class BrowseViewModel(
    private val getRecentPacks: GetRecentPacksUseCase,
    private val getGifPacksSuggestions: GetGifPacksSuggestionsUseCase
) : ViewModel() {

    private val _browseScreenUiState = MutableLiveData<BrowseScreenUiState>(BrowseScreenUiState.Loading)
    val browseScreenUiState: LiveData<BrowseScreenUiState>
        get() = _browseScreenUiState

    /**
     * delay is used here to demonstrate recomposition based on browseScreenUiState value
     * Since we aren't loading the data from an API, the loading screen would barely be visible
     *
     * We show Error state by default for demonstration purposes
     */
    init {
        _browseScreenUiState.value = BrowseScreenUiState.Loading
        viewModelScope.launch {
//            delay(3000L)
//            _browseScreenUiState.value = BrowseScreenUiState.Error
            getBroseScreenData()
        }
    }

    fun getBroseScreenData() {
        viewModelScope.launch {
            val recentPacks = getRecentPacks()
            val suggestedPacks = getGifPacksSuggestions()

            val browseScreenItems = mutableListOf<BrowseListItem>()
            browseScreenItems.add(recentPacks.toRecentsSection())
            browseScreenItems.addAll(suggestedPacks.mapToSuggestedSections())

            _browseScreenUiState.value = BrowseScreenUiState.Ready(browseScreenItems)
        }
    }
}