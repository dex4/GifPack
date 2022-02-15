package io.gifpack.core.data

data class GifDetails(
    val id: Int,
    val url: String,
    val name: String? = null,
    val tags: List<String> = listOf()
)