package io.gifpack.util.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import io.gifpack.R

typealias OnActionButtonClick = () -> Unit

@Composable
fun ErrorScreen(
    titleText: String,
    descriptionText: String,
    actionButtonText: String,
    modifier: Modifier = Modifier,
    onActionButtonClick: OnActionButtonClick? = null
) {

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = titleText,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = descriptionText,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.error_state_text_spacing_vertical))
        )
        if (onActionButtonClick != null) {
            Button(
                onClick = { onActionButtonClick() },
                modifier = Modifier.padding(top = dimensionResource(R.dimen.error_state_button_spacing_vertical))
            ) {
                Text(actionButtonText)
            }
        }
    }

}