package io.gifpack.feature.browse.recommendedsection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.gifpack.util.Image

@Composable
fun PacksList(packs: List<GifPackItem>, modifier: Modifier = Modifier) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = modifier, contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(packs) { pack ->
            GifPack(pack = pack)
        }
    }
}

@Composable
fun GifPack(pack: GifPackItem) {
    Column(modifier = Modifier.size(width = 120.dp, height = 180.dp)) {
        Image(
            url = pack.imageUrl,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
        )
        pack.title?.let { title ->
            Text(
                text = title,
                modifier = Modifier.padding(bottom = 2.dp),
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        pack.description?.let { description ->
            Text(
                text = description,
                modifier = Modifier.padding(bottom = 2.dp),
                style = MaterialTheme.typography.caption,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

data class GifPackItem(
    val packId: Int,
    val imageUrl: String,
    val title: String? = null,
    val description: String? = null
)