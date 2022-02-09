package io.gifpack.feature.browse.recents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.gifpack.util.Image

@Composable
fun RecentPack(item: RecentPackItem) {
    Row(
        modifier = Modifier
            .border(BorderStroke(0.dp, Color.Transparent))
            .clip(RoundedCornerShape(4.dp))
            .background(Color(32,32,32)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(item.imageUrl, modifier = Modifier.size(64.dp))
        Text(
            text = item.name,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}