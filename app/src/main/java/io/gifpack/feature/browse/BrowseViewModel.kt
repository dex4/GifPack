package io.gifpack.feature.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class BrowseViewModel @Inject constructor() : ViewModel() {

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
            delay(3000L)
            _browseScreenUiState.value = BrowseScreenUiState.Error
        }
    }

    fun getBroseScreenData() {
        _browseScreenUiState.value = BrowseScreenUiState.Ready(browseScreenData)
    }
}