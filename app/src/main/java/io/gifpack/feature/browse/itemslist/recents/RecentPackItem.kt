package io.gifpack.feature.browse.itemslist.recents

import io.gifpack.core.data.model.GifsPack

data class RecentPackItem(
    val packId: Int,
    val imageUrl: String,
    val name: String
)

fun GifsPack.toRecentPackItem(): RecentPackItem = RecentPackItem(id, imageUrl ?: "", name ?: "")

fun List<GifsPack>.mapToRecentPackItemsList(): List<RecentPackItem> = this.map { it.toRecentPackItem() }
