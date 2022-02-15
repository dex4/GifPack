package io.gifpack.core.data

data class GifsPack(
    val id: Int,
    val name: String?,
    val gifsList: List<GifDetails>,
    val provider: String? = null,
    val providerImageUrl: String? = null,
    val imageUrl: String? = null,
    val description: String? = null
)