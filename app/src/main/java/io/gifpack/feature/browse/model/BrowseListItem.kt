package io.gifpack.feature.browse.model

import io.gifpack.feature.browse.recents.RecentPackItem

sealed class BrowseListItem(val id: Int) {

    data class RecentPacksList(
        val packsList: List<RecentPackItem>
    ) : BrowseListItem(RECENT_PACKS_SECTION_ID)

    data class SectionHeader(
        val sectionHeaderId: Int,
        val title: String,
        val description: String? = null,
        val imageUrl: String? = null
    ) : BrowseListItem(sectionHeaderId)

    companion object {

        const val RECENT_PACKS_SECTION_ID = 1
    }
}
