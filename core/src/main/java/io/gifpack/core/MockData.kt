package io.gifpack.core

import io.gifpack.core.data.GifDetailsDao
import io.gifpack.core.data.GifsPackDao

const val CD_PROJEKT_RED_PROVIDER_NAME = "CD Projekt Red"
const val FROM_SOFTWARE_PROVIDER_NAME = "From Software"
const val TEAM_CHERRY_PROVIDER_NAME = "Team Cherry"

const val CD_PROJEKT_RED_PROVIDER_IMAGE_URL = "https://picsum.photos/id/93/200/200"
const val FROM_SOFTWARE_PROVIDER_IMAGE_URL = "https://picsum.photos/id/92/200/200"

internal val gifsList = listOf(
    GifDetailsDao(
        1,
        "https://media.giphy.com/media/AQRapWCgC7dThyVEYb/giphy-downsized.gif",
        "Praise The Sun"
    ),
    GifDetailsDao(
        2,
        "https://media.giphy.com/media/tDfClZn3KzGpSL2PXk/giphy.gif",
        "Anor Londo"
    ),
    GifDetailsDao(
        3,
        "https://media.giphy.com/media/TY2YdGc15h1GMnorve/giphy-downsized.gif",
        "Artorias"
    ),
    GifDetailsDao(
        5,
        "https://media.giphy.com/media/twq99EDXbUs8BOdrTY/giphy-downsized.gif",
        "Yhorm, Old Friend"
    ),
    GifDetailsDao(
        5,
        "https://media.giphy.com/media/vd6XXPxfaRGi71XsU0/giphy-downsized.gif",
        "Emerald Herald"
    ),
    GifDetailsDao(
        6,
        "https://media.giphy.com/media/UpS6sRrDVJ4cxqtvgR/giphy-downsized.gif",
        "Agheel vs Spells"
    ),
    GifDetailsDao(
        7,
        "https://media.giphy.com/media/KufI7NaMR1Epa/giphy-downsized.gif",
        "Hollow Knight Traversal"
    ),
    GifDetailsDao(
        8,
        "https://media.giphy.com/media/Naybz692ExelW/giphy-downsized.gif",
        "Hoonters"
    ),
    GifDetailsDao(
        9,
        "https://media.giphy.com/media/1XhyrA42GVtLICljqW/giphy.gif",
        "Sekiro Moonlight"
    )
)

internal val gifPacks = listOf(
    // Recents
    GifsPackDao(
        0,
        "Dark Souls",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/12/200/200"
    ),
    GifsPackDao(
        1,
        "Elden Ring",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/22/200/200"
    ),
    GifsPackDao(
        2,
        "Cyberpunk 2077",
        gifsList,
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/32/200/200"
    ),
    GifsPackDao(
        3,
        "The Witcher 3",
        gifsList,
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/42/200/200"
    ),
    GifsPackDao(
        4,
        "Bloodborne",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/52/200/200"
    ),
    GifsPackDao(5, "Hollow Knight", gifsList, TEAM_CHERRY_PROVIDER_NAME, null, ""),
    // From Software
    GifsPackDao(
        6,
        "Dark Souls 2",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/12/200/200"
    ),
    GifsPackDao(
        7,
        "Elden Ring",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/22/200/200",
        "Big Dark Souls"
    ),
    GifsPackDao(
        8,
        "Armored Core",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/32/200/200"
    ),
    GifsPackDao(
        9,
        "Dark Souls: Remastered",
        gifsList,
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/42/200/200",
        "60fps!"
    ),
    GifsPackDao(10, null, gifsList, FROM_SOFTWARE_PROVIDER_NAME, FROM_SOFTWARE_PROVIDER_IMAGE_URL, "https://picsum.photos/id/52/200/200"),
    // CD Projekt Red
    GifsPackDao(
        11,
        "The Witcher 2",
        gifsList,
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/13/200/200"
    ),
    GifsPackDao(
        12,
        "The Witcher 3",
        gifsList,
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/23/200/200",
        "Silver Swords"
    ),
    GifsPackDao(
        13,
        "Cyberpunk 2077",
        gifsList,
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/33/200/200"
    ),
    GifsPackDao(
        14,
        "The Witcher 3",
        gifsList,
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/43/200/200",
        "The Wild Hunt Best Of Eredin"
    ),
    // Team Cherry
    GifsPackDao(15, "Zote", gifsList, TEAM_CHERRY_PROVIDER_NAME, imageUrl = "https://picsum.photos/id/14/200/200"),
    GifsPackDao(
        16,
        null,
        gifsList,
        TEAM_CHERRY_PROVIDER_NAME,
        "",
        "https://picsum.photos/id/24/200/200",
        "Road to Hallownest - Run through Forgotten Crossroads"
    ),
    GifsPackDao(17, "Cornifer", gifsList, TEAM_CHERRY_PROVIDER_NAME, imageUrl = "https://picsum.photos/id/34/200/200"),
    GifsPackDao(
        18,
        "Pantheon",
        gifsList,
        TEAM_CHERRY_PROVIDER_NAME,
        imageUrl = "https://picsum.photos/id/44/200/200",
        description = "Most awesome combos"
    )
)