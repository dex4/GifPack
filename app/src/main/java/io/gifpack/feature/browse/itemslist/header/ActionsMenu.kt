package io.gifpack.feature.browse.itemslist.header

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

typealias OnActionsMenuItemClick = (ActionsMenuOption) -> Unit

@Composable
fun ActionsMenu(
    hasNotifications: Boolean,
    onActionsMenuItemClick: OnActionsMenuItemClick,
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
                    onClick = { onActionsMenuItemClick(ActionsMenuOption.NOTIFICATIONS) }
                )
        )
        Image(
            resId = R.drawable.ic_history,
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.browse_actions_menu_button_spacing_horizontal))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(false),
                    onClick = { onActionsMenuItemClick(ActionsMenuOption.SHARED_HISTORY) }
                )
        )
        Image(
            resId = R.drawable.ic_settings,
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(false),
                onClick = { onActionsMenuItemClick(ActionsMenuOption.SETTINGS) }
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
