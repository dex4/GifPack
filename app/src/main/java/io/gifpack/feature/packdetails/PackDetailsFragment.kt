package io.gifpack.feature.packdetails

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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.gifpack.ui.theme.GifPackTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

@ExperimentalFoundationApi
class PackDetailsFragment : Fragment() {

    private val args by navArgs<PackDetailsFragmentArgs>()
    private val packId by lazy { args.packId }
    private val viewModel by viewModel<PackDetailsViewModel> { parametersOf(packId) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GifPackTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        PackDetailsScreen(viewModel, ::onNavigateUp)
                    }
                }
            }
        }

    private fun onNavigateUp() = findNavController().navigateUp()
}