package io.gifpack.feature.packdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.gifpack.core.GetPackByIdUseCase
import io.gifpack.core.data.model.GifsPack

class PackDetailsViewModel(
    packId: Int,
    getPackById: GetPackByIdUseCase
) : ViewModel() {

    private val _pack = MutableLiveData<GifsPack>()
    val pack: LiveData<GifsPack>
        get() = _pack

    init {
        getPackById(packId)?.let {
            _pack.value = it
        }
    }
}