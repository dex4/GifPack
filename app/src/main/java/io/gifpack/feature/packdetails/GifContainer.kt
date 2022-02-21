package io.gifpack.feature.packdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import io.gifpack.R
import io.gifpack.core.data.GifDetails
import io.gifpack.util.AnimatedImage

@Composable
fun GifContainer(gifDetails: GifDetails) {
    Box(
        modifier = Modifier
            .height(dimensionResource(R.dimen.pack_details_gif_height))
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.pack_details_gif_corner_radius)))
    ) {
        AnimatedImage(
            url = gifDetails.url,
            modifier = Modifier.matchParentSize()
        )
        gifDetails.name?.let { gifName ->
            Text(
                text = gifName,
                color = colorResource(R.color.white),
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                colorResource(R.color.pack_details_gif_name_gradient_start_color),
                                colorResource(R.color.pack_details_gif_name_gradient_end_color)
                            )
                        )
                    )
                    .padding(dimensionResource(R.dimen.pack_details_gif_name_spacing))
            )
        }
    }
}