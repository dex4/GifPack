package io.gifpack.util

import android.os.Build.VERSION.SDK_INT
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import io.gifpack.R

@Composable
fun AnimatedImage(
    url: String?,
    modifier: Modifier = Modifier
) {
    androidx.compose.foundation.Image(
        painter = rememberImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .decoder(
                    if (SDK_INT >= 28) {
                        ImageDecoderDecoder(LocalContext.current)
                    } else {
                        GifDecoder()
                    }
                )
                .data(url)
                .placeholder(R.drawable.ic_loading_placeholder)
                .error(R.drawable.ic_error_placeholder)
                .build()
        ),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )
}