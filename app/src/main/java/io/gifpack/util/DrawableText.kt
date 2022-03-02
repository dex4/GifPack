package io.gifpack.util

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R

@Composable
fun DrawableText(
    text: String,
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    fontWeight: FontWeight = FontWeight.Normal,
    textSpacingFromDrawable: Dp = dimensionResource(R.dimen.default_drawable_text_spacing)
) {
    Row(modifier.wrapContentHeight(Alignment.Top)) {
        Image(
            painter = rememberImagePainter(drawable),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.default_icon_size))
                .align(Alignment.CenterVertically)
        )
        Text(
            text = text,
            style = textStyle,
            fontWeight = fontWeight,
            modifier = Modifier.padding(start = textSpacingFromDrawable)
        )
    }
}