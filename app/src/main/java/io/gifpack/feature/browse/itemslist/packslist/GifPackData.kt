package io.gifpack.feature.browse.itemslist.packslist

data class GifPackData(
    val packId: Int,
    val imageUrl: String,
    val title: String? = null,
    val description: String? = null
)
