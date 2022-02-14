package io.gifpack.feature.browse.itemslist.sectionheader

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SectionHeaderData(
    val title: String,
    val description: String? = null,
    val imageUrl: String? = null
)

fun SectionHeaderData.determinePaddingForHeaderTitle(): Dp =
    if(imageUrl.isNullOrEmpty()) 0.dp else 8.dp
