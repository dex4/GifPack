package io.gifpack.feature.browse.header

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.gifpack.R
import io.gifpack.util.Image

typealias OnActionsMenuItemClick = (String) -> Unit

@Composable
fun ActionsMenu(
    hasNotifications: Boolean,
    onNotificationsClick: OnActionsMenuItemClick,
    onHistoryClick: OnActionsMenuItemClick,
    onSettingsClick: OnActionsMenuItemClick,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Image(
            resId = getNotificationsRes(hasNotifications),
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(false),
                    onClick = { onNotificationsClick("NotificationsScreen") }
                )
        )
        Image(
            resId = R.drawable.ic_history,
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(false),
                    onClick = { onHistoryClick("SharedHistoryScreen") }
                )
        )
        Image(
            resId = R.drawable.ic_settings,
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(false),
                onClick = { onSettingsClick("SettingsScreen") }
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
