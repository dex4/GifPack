package io.gifpack.feature.browse.itemslist.model

import io.gifpack.core.data.model.GifsPack
import io.gifpack.feature.browse.itemslist.packslist.GifPackData
import io.gifpack.feature.browse.itemslist.packslist.mapToGifsPackDataList
import io.gifpack.feature.browse.itemslist.recents.RecentPackItem
import io.gifpack.feature.browse.itemslist.recents.mapToRecentPackItemsList
import io.gifpack.feature.browse.itemslist.sectionheader.SectionHeaderData
import io.gifpack.feature.browse.itemslist.sectionheader.extractSectionHeaderData

sealed class BrowseListItem(val id: Int) {

    data class RecentPacksList(
        val packsList: List<RecentPackItem>
    ) : BrowseListItem(RECENT_PACKS_SECTION_ID)

    data class GifPacksList(
        val gifPacksListId: Int,
        val gifPacks: List<GifPackData>
    ) : BrowseListItem(gifPacksListId)

    data class SectionHeader(
        val sectionHeaderId: Int,
        val sectionHeaderData: SectionHeaderData
    ) : BrowseListItem(sectionHeaderId)

    companion object {

        const val RECENT_PACKS_SECTION_ID = 1
    }
}

val List<GifsPack>.sectionHeaderId: Int get() = first().description.hashCode()

val List<GifsPack>.packsListId: Int get() = hashCode()

fun List<GifsPack>.mapToSuggestedSections(): List<BrowseListItem> {
    val suggestedSections = mutableListOf<BrowseListItem>()

    groupBy { it.provider }.values.forEach { gifsPack ->

        val sectionHeader = BrowseListItem.SectionHeader(
            gifsPack.sectionHeaderId,
            gifsPack.extractSectionHeaderData()
        )

        val packsSection = BrowseListItem.GifPacksList(
            gifsPack.packsListId,
            gifsPack.mapToGifsPackDataList()
        )

        suggestedSections.add(sectionHeader)
        suggestedSections.add(packsSection)
    }

    return suggestedSections
}

fun List<GifsPack>.toRecentsSection(): BrowseListItem.RecentPacksList =
    BrowseListItem.RecentPacksList(mapToRecentPackItemsList())
