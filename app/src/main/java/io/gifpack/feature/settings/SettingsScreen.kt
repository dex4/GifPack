package io.gifpack.feature.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import io.gifpack.R
import io.gifpack.util.DrawableText

@Composable
fun SettingsScreen() {
    DrawableText(
        text = "Settings",
        modifier = Modifier.padding(
            start = dimensionResource(R.dimen.horizontal_guideline),
            top = dimensionResource(R.dimen.vertical_guideline)
        ),
        drawable = R.drawable.ic_settings,
        textStyle = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
}