package io.gifpack.feature.browse.recommendedsection

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.gifpack.feature.browse.model.BrowseListItem
import io.gifpack.util.Image

@Composable
fun SectionHeader(sectionHeader: BrowseListItem.SectionHeader, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        sectionHeader.imageUrl?.let { imageUrl ->
            Image(
                url = imageUrl,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(56.dp)
            )
        }
        Column(modifier = Modifier.padding(start = sectionHeader.determinePaddingForHeaderTitle())) {
            sectionHeader.description?.let { description ->
                Text(text = description.uppercase(), style = MaterialTheme.typography.overline)
            }
            Text(text = sectionHeader.title, style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
        }
    }
}

private fun BrowseListItem.SectionHeader.determinePaddingForHeaderTitle(): Dp =
    if(imageUrl.isNullOrEmpty()) 0.dp else 8.dp
