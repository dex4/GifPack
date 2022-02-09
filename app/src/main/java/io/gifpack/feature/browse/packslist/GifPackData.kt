package io.gifpack.feature.browse.packslist

data class GifPackData(
    val packId: Int,
    val imageUrl: String,
    val title: String? = null,
    val description: String? = null
)
