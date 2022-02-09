package io.gifpack.feature.browse.header

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R
import io.gifpack.util.Image

typealias OnActionsMenuItemClick = (String, Context) -> Unit

@Composable
fun ActionsMenu(
    hasNotifications: Boolean,
    onNotificationsClick: OnActionsMenuItemClick,
    onHistoryClick: OnActionsMenuItemClick,
    onSettingsClick: OnActionsMenuItemClick,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Row(modifier = modifier) {
        Image(
            resId = getNotificationsRes(hasNotifications),
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(false),
                    onClick = { onNotificationsClick("Notifications", context) }
                )
        )
        Image(
            resId = R.drawable.ic_history,
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(false),
                    onClick = { onHistoryClick("History", context) }
                )
        )
        Image(
            resId = R.drawable.ic_settings,
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(false),
                onClick = { onSettingsClick("Settings", context) }
            )
        )
    }
}

@DrawableRes
private fun getNotificationsRes(hasNotifications: Boolean = false): Int =
    if (hasNotifications) {
        R.drawable.ic_notifications_active
    } else {
        R.drawable.ic_notifications
    }
