package io.gifpack.feature.browse.packslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R

@Composable
fun PacksList(packs: List<GifPackData>, modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.browse_packs_list_item_spacing)),
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.browse_packs_list_horizontal_content_padding))
    ) {
        items(packs) { pack ->
            GifPack(pack = pack)
        }
    }
}