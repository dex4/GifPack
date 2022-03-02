package io.gifpack.core.di

import io.gifpack.core.GetGifPacksSuggestionsUseCase
import io.gifpack.core.GetPackByIdUseCase
import io.gifpack.core.GetRecentPacksUseCase
import org.koin.dsl.module

val useCases = module {
    factory { GetGifPacksSuggestionsUseCase() }
    factory { GetPackByIdUseCase() }
    factory { GetRecentPacksUseCase() }
}