package io.gifpack.core.data

internal data class GifDetailsDao(
    val id: Int,
    val url: String,
    val name: String? = null,
    val tags: List<String> = listOf()
)

internal fun GifDetailsDao.toGifDetails(): GifDetails = GifDetails(id, url, name, tags)

internal fun List<GifDetailsDao>.mapToGifDetailsList(): List<GifDetails> = this.map { it.toGifDetails() }