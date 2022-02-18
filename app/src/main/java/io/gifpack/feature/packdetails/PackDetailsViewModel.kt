package io.gifpack.feature.packdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.gifpack.core.GetPackByIdUseCase
import io.gifpack.core.data.GifsPack
import javax.inject.Inject

@HiltViewModel
class PackDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPackById: GetPackByIdUseCase
) : ViewModel() {

    private val packId: Int

    private val _pack = MutableLiveData<GifsPack>()
    val pack: LiveData<GifsPack>
        get() = _pack

    init {
        packId = savedStateHandle.get<Int>("packId") ?: -1
        Log.d("WRKR", "$packId")

        getPackById(packId)?.let {
            _pack.value = it
        }
    }
}