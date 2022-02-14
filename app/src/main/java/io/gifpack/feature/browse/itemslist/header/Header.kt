package io.gifpack.feature.browse.itemslist.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BrowseHeader(
    hasNotifications: Boolean,
    onActionsMenuItemClick: OnActionsMenuItemClick,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Greeting()
        ActionsMenu(
            hasNotifications,
            onActionsMenuItemClick
        )
    }
}