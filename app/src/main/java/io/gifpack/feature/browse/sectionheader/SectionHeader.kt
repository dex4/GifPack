package io.gifpack.feature.browse.sectionheader

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.gifpack.R
import io.gifpack.util.Image

@Composable
fun SectionHeader(sectionHeaderData: SectionHeaderData, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        sectionHeaderData.imageUrl?.let { imageUrl ->
            Image(
                url = imageUrl,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(dimensionResource(R.dimen.browse_section_header_image_size))
            )
        }
        Column(modifier = Modifier.padding(start = sectionHeaderData.determinePaddingForHeaderTitle())) {
            sectionHeaderData.description?.let { description ->
                Text(text = description.uppercase(), style = MaterialTheme.typography.overline)
            }
            Text(text = sectionHeaderData.title, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
        }
    }
}
