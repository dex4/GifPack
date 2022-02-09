package io.gifpack.feature.browse

import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.feature.browse.recents.RecentPackItem
import io.gifpack.feature.browse.recommendedsection.GifPackItem

val recentPacks = BrowseListItem.RecentPacksList(
    listOf(
        RecentPackItem(0, "https://picsum.photos/id/12/200/200", "Dark Souls"),
        RecentPackItem(1, "https://picsum.photos/id/22/200/200", "Elden Ring"),
        RecentPackItem(2, "https://picsum.photos/id/32/200/200", "Cyberpunk 2077"),
        RecentPackItem(3, "https://picsum.photos/id/42/200/200", "The Witcher 3"),
        RecentPackItem(4, "https://picsum.photos/id/52/200/200", "Bloodborne"),
        RecentPackItem(5, "", "Hollow Knight")
    )
)

val fromSoftwarePacks = listOf(
    GifPackItem(0, "https://picsum.photos/id/12/200/200", "Dark Souls"),
    GifPackItem(1, "https://picsum.photos/id/22/200/200", description = "Elden Ring"),
    GifPackItem(2, "https://picsum.photos/id/32/200/200", "Cyberpunk 2077"),
    GifPackItem(3, "https://picsum.photos/id/42/200/200", "The Witcher 3", "The Wild Hunt Best Of Eredin"),
    GifPackItem(4, "https://picsum.photos/id/52/200/200"),
    GifPackItem(5, "", "Hollow Knight")
)