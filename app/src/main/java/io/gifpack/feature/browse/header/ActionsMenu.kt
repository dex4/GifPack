package io.gifpack.feature.browse.header

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R
import io.gifpack.util.Image

@Composable
fun ActionsMenu(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Image(
            resId = getNotificationsRes(),
            modifier = Modifier.padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
        )
        Image(
            resId = R.drawable.ic_history,
            modifier = Modifier.padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
        )
        Image(resId = R.drawable.ic_settings)
    }
}

@DrawableRes
private fun getNotificationsRes(hasNotifications: Boolean = false): Int =
    if (hasNotifications) {
        R.drawable.ic_notifications_active
    } else {
        R.drawable.ic_notifications
    }
