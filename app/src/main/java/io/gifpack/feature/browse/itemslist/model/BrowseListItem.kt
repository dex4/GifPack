package io.gifpack.feature.browse.itemslist.model

import io.gifpack.feature.browse.itemslist.packslist.GifPackData
import io.gifpack.feature.browse.itemslist.recents.RecentPackItem
import io.gifpack.feature.browse.itemslist.sectionheader.SectionHeaderData

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
