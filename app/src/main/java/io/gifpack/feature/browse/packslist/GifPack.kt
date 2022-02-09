package io.gifpack.feature.browse.packslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.gifpack.R
import io.gifpack.util.Image

@Composable
fun GifPack(pack: GifPackData) {
    Column(
        modifier = Modifier.size(
            width = dimensionResource(R.dimen.browse_gif_pack_width),
            height = dimensionResource(R.dimen.browse_gif_pack_height)
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