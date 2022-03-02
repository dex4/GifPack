package io.gifpack.di

import io.gifpack.feature.browse.BrowseViewModel
import io.gifpack.feature.packdetails.PackDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModels = module {
    viewModel { BrowseViewModel(get(), get()) }
    viewModel { (packId: Int) -> PackDetailsViewModel(packId, get()) }
}