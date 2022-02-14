package io.gifpack.data

import javax.inject.Inject

class GetRecentPacksUseCase @Inject constructor(){

    operator fun invoke(): List<GifsPack> {
        val recents = gifPacks.subList(0, 5)
        return recents.mapToGifsPackList()
    }
}