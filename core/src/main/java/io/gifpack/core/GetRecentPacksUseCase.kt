package io.gifpack.core

import io.gifpack.core.data.GifsPack
import io.gifpack.core.data.mapToGifsPackList
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class GetRecentPacksUseCase @Inject constructor() {

    suspend operator fun invoke(): List<GifsPack> =
        withContext(IO) {
            val recents = gifPacks.subList(0, 6)

            recents.mapToGifsPackList()
        }
}