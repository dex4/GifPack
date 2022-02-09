package io.gifpack.util

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import io.gifpack.R

@Composable
fun Image(@DrawableRes resId: Int, modifier: Modifier = Modifier) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun Image(url: String?, modifier: Modifier = Modifier) {
    androidx.compose.foundation.Image(
        painter = rememberImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(url)
                .placeholder(R.drawable.ic_loading_placeholder)
                .error(R.drawable.ic_error_placeholder)
                .build()
        ),
        contentDescription = null,
        modifier = modifier
    )
}