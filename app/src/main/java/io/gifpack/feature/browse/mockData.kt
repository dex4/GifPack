package io.gifpack.feature.browse

import io.gifpack.feature.browse.itemslist.model.BrowseListItem
import io.gifpack.feature.browse.itemslist.packslist.GifPackData
import io.gifpack.feature.browse.itemslist.recents.RecentPackItem
import io.gifpack.feature.browse.itemslist.sectionheader.SectionHeaderData

val recentPacks = listOf(
    RecentPackItem(0, "https://picsum.photos/id/12/200/200", "Dark Souls"),
    RecentPackItem(1, "https://picsum.photos/id/22/200/200", "Elden Ring"),
    RecentPackItem(2, "https://picsum.photos/id/32/200/200", "Cyberpunk 2077"),
    RecentPackItem(3, "https://picsum.photos/id/42/200/200", "The Witcher 3"),
    RecentPackItem(4, "https://picsum.photos/id/52/200/200", "Bloodborne"),
    RecentPackItem(5, "", "Hollow Knight")
)

val fromSoftwarePacks = listOf(
    GifPackData(0, "https://picsum.photos/id/12/200/200", "Dark Souls 2"),
    GifPackData(1, "https://picsum.photos/id/22/200/200", "Elden Ring", "Big Dark Souls"),
    GifPackData(2, "https://picsum.photos/id/32/200/200", "Armored Core"),
    GifPackData(3, "https://picsum.photos/id/42/200/200", "Dark Souls: Remastered", "60fps!"),
    GifPackData(4, "https://picsum.photos/id/52/200/200")
)

val cdProjektRed = listOf(
    GifPackData(0, "https://picsum.photos/id/13/200/200", "The Witcher 2"),
    GifPackData(1, "https://picsum.photos/id/23/200/200", "The Witcher 3", "Silver Swords"),
    GifPackData(2, "https://picsum.photos/id/33/200/200", "Cyberpunk 2077"),
    GifPackData(3, "https://picsum.photos/id/43/200/200", "The Witcher 3", "The Wild Hunt Best Of Eredin")
)

val hollowKnight = listOf(
    GifPackData(0, "https://picsum.photos/id/14/200/200", "Zote"),
    GifPackData(1, "https://picsum.photos/id/24/200/200", description = "Road to Hallownest - Run through Forgotten Crossroads"),
    GifPackData(2, "https://picsum.photos/id/34/200/200", "Cornifer"),
    GifPackData(3, "https://picsum.photos/id/44/200/200", "Pantheon", "Most awesome combos")
)

val browseScreenData = listOf(
    BrowseListItem.RecentPacksList(recentPacks),
    BrowseListItem.SectionHeader(
        0, SectionHeaderData(
            "From Software",
            "For fans of",
            "https://picsum.photos/id/92/200/200",
        )
    ),
    BrowseListItem.GifPacksList(1, fromSoftwarePacks),
    BrowseListItem.SectionHeader(
        2, SectionHeaderData(
            "CD Projekt Red",
            imageUrl = "https://picsum.photos/id/93/200/200"
        )
    ),
    BrowseListItem.GifPacksList(3, cdProjektRed),
    BrowseListItem.SectionHeader(4, SectionHeaderData("Hollow Knight")),
    BrowseListItem.GifPacksList(5, hollowKnight)
)
