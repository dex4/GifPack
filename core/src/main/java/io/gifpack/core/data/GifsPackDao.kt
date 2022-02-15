package io.gifpack.core.data

internal data class GifsPackDao(
    val id: Int,
    val name: String?,
    val gifsList: List<GifDetailsDao>,
    val provider: String? = null,
    val providerImageUrl: String? = null,
    val imageUrl: String? = null,
    val description: String? = null
)

internal fun GifsPackDao.toGifsPack(): GifsPack =
    GifsPack(id, name, gifsList.mapToGifDetailsList(), provider, providerImageUrl, imageUrl, description)

internal fun List<GifsPackDao>.mapToGifsPackList(): List<GifsPack> = this.map { it.toGifsPack() }