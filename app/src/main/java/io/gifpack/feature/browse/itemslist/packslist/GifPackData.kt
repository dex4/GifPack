package io.gifpack.feature.browse.itemslist.packslist

import io.gifpack.core.data.model.GifsPack

data class GifPackData(
    val packId: Int,
    val imageUrl: String,
    val title: String? = null,
    val description: String? = null
)

fun List<GifsPack>.mapToGifsPackDataList() : List<GifPackData> = map { it.toGifsPackData() }

fun GifsPack.toGifsPackData(): GifPackData =
    GifPackData(
        id,
        imageUrl ?: "",
        name,
        description
    )