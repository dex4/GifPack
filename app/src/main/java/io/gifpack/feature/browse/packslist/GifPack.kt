package io.gifpack.feature.browse.packslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import io.gifpack.R
import io.gifpack.util.Image

@Composable
fun GifPack(pack: GifPackData, onGifPackClick: OnGifPackClick) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .size(
                width = dimensionResource(R.dimen.browse_gif_pack_width),
                height = dimensionResource(R.dimen.browse_gif_pack_height)
            )
            .clip(RoundedCornerShape(dimensionResource(R.dimen.browse_gif_pack_image_corner_radius)))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onGifPackClick(pack.packId, context) }
            )
    ) {
        Image(
            url = pack.imageUrl,
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.browse_gif_pack_image_margin_bottom))
                .aspectRatio(1f)
                .clip(RoundedCornerShape(dimensionResource(R.dimen.browse_gif_pack_image_corner_radius)))
        )
        pack.title?.let { title ->
            Text(
                text = title,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.browse_gif_pack_text_margin_bottom)),
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        pack.description?.let { description ->
            Text(
                text = description,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.browse_gif_pack_text_margin_bottom)),
                style = MaterialTheme.typography.caption,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}