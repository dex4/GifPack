package io.gifpack.core

import io.gifpack.core.data.GifsPack
import io.gifpack.core.data.mapToGifsPackList
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class GetGifPacksSuggestionsUseCase @Inject constructor() {

    suspend operator fun invoke(): List<GifsPack> =
        withContext(IO) {
            gifPacks.subList(6, gifPacks.lastIndex).mapToGifsPackList()
        }
}