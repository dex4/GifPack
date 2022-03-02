package io.gifpack.core

import io.gifpack.core.data.dao.toGifsPack
import io.gifpack.core.data.model.GifsPack

class GetPackByIdUseCase {

    operator fun invoke(packId: Int): GifsPack? =
        gifPacks.firstOrNull { it.id == packId }?.toGifsPack()
}