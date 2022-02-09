package io.gifpack.feature.browse.model

import io.gifpack.feature.browse.recents.RecentPackItem
import io.gifpack.feature.browse.recommendedsection.GifPackItem
import io.gifpack.feature.browse.recommendedsection.SectionHeaderData

sealed class BrowseListItem(val id: Int) {

    data class RecentPacksList(
        val packsList: List<RecentPackItem>
    ) : BrowseListItem(RECENT_PACKS_SECTION_ID)

    data class GifPacksList(
        val gifPacksListId: Int,
        val gifPacks: List<GifPackItem>
    ) : BrowseListItem(gifPacksListId)

    data class SectionHeader(
        val sectionHeaderId: Int,
        val sectionHeaderData: SectionHeaderData
    ) : BrowseListItem(sectionHeaderId)

    companion object {

        const val RECENT_PACKS_SECTION_ID = 1
    }
}
