package io.gifpack.core

import io.gifpack.core.data.dao.mapToGifsPackList
import io.gifpack.core.data.model.GifsPack
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class GetRecentPacksUseCase {

    suspend operator fun invoke(): List<GifsPack> =
        withContext(IO) {
            val recents = gifPacks.subList(0, 6)

            recents.mapToGifsPackList()
        }
}