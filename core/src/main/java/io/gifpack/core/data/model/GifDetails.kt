package io.gifpack.core.data.model

data class GifDetails(
    val id: Int,
    val url: String,
    val name: String? = null,
    val tags: List<String> = listOf()
)