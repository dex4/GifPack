package io.gifpack.core

import io.gifpack.core.data.GifsPack
import io.gifpack.core.data.toGifsPack
import javax.inject.Inject

class GetPackByIdUseCase @Inject constructor() {

    operator fun invoke(packId: Int): GifsPack? =
        gifPacks.firstOrNull { it.id == packId }?.toGifsPack()
}