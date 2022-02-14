package io.gifpack.feature.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.gifpack.feature.browse.model.BrowseListItem
import javax.inject.Inject

@HiltViewModel
class BrowseViewModel @Inject constructor() : ViewModel() {

    private val _browseScreenContent = MutableLiveData<List<BrowseListItem>>()
    val browseScreenContent: LiveData<List<BrowseListItem>>
        get() = _browseScreenContent

    init {
        _browseScreenContent.value = browseScreenData
    }
}