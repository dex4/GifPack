package io.gifpack.feature.browse.itemslist.recents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.gifpack.R
import io.gifpack.feature.browse.itemslist.OnPackClick
import io.gifpack.util.Image

@Composable
fun RecentPack(pack: RecentPackItem, onPackClick: OnPackClick) {
    Row(
        modifier = Modifier
            .border(BorderStroke(0.dp, Color.Transparent))
            .clip(RoundedCornerShape(dimensionResource(R.dimen.browse_recent_pack_corner_radius)))
            .background(colorResource(R.color.browse_recent_pack_background))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onPackClick(pack.packId) }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(pack.imageUrl, modifier = Modifier.size(dimensionResource(R.dimen.browse_recent_pack_image_size)))
        Text(
            text = pack.name,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.browse_recent_pack_name_margin_horizontal)),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}