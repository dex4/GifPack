package io.gifpack.core

import io.gifpack.core.data.dao.mapToGifsPackList
import io.gifpack.core.data.model.GifsPack
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class GetGifPacksSuggestionsUseCase {

    suspend operator fun invoke(): List<GifsPack> =
        withContext(IO) {
            gifPacks.subList(6, gifPacks.lastIndex).mapToGifsPackList()
        }
}