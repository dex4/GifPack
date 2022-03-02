package io.gifpack.feature.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import io.gifpack.feature.browse.itemslist.header.ActionsMenuOption
import io.gifpack.ui.theme.GifPackTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalFoundationApi
class BrowseFragment : Fragment() {

    private val viewModel by viewModel<BrowseViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GifPackTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        BrowseScreen(viewModel, ::onActionsMenuItemClick, ::onPackClick)
                    }
                }
            }
        }

    private fun onPackClick(packId: Int) =
        findNavController().navigate(BrowseFragmentDirections.actionBrowseFragmentToPackDetailsFragment(packId))

    private fun onActionsMenuItemClick(selectedActionsMenuOption: ActionsMenuOption) {
        val actionMenuDirection: NavDirections =
            when (selectedActionsMenuOption) {
                ActionsMenuOption.NOTIFICATIONS -> BrowseFragmentDirections.actionBrowseFragmentToNotificationsFragment()
                ActionsMenuOption.SETTINGS -> BrowseFragmentDirections.actionBrowseFragmentToSettingsFragment()
                ActionsMenuOption.SHARED_HISTORY -> BrowseFragmentDirections.actionBrowseFragmentToSharedHistoryFragment()
            }

        findNavController().navigate(actionMenuDirection)
    }
}
