package io.gifpack.core

import io.gifpack.core.data.GifsPackDao

const val CD_PROJEKT_RED_PROVIDER_NAME = "CD Projekt Red"
const val FROM_SOFTWARE_PROVIDER_NAME = "From Software"
const val TEAM_CHERRY_PROVIDER_NAME = "Team Cherry"

const val CD_PROJEKT_RED_PROVIDER_IMAGE_URL = "https://picsum.photos/id/93/200/200"
const val FROM_SOFTWARE_PROVIDER_IMAGE_URL = "https://picsum.photos/id/92/200/200"

internal val gifPacks = listOf(
    // Recents
    GifsPackDao(
        0,
        "Dark Souls",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/12/200/200"
    ),
    GifsPackDao(
        1,
        "Elden Ring",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/22/200/200"
    ),
    GifsPackDao(
        2,
        "Cyberpunk 2077",
        listOf(),
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/32/200/200"
    ),
    GifsPackDao(
        3,
        "The Witcher 3",
        listOf(),
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/42/200/200"
    ),
    GifsPackDao(
        4,
        "Bloodborne",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/52/200/200"
    ),
    GifsPackDao(5, "Hollow Knight", listOf(), TEAM_CHERRY_PROVIDER_NAME, null, ""),
    // From Software
    GifsPackDao(
        6,
        "Dark Souls 2",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/12/200/200"
    ),
    GifsPackDao(
        7,
        "Elden Ring",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/22/200/200",
        "Big Dark Souls"
    ),
    GifsPackDao(
        8,
        "Armored Core",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/32/200/200"
    ),
    GifsPackDao(
        9,
        "Dark Souls: Remastered",
        listOf(),
        FROM_SOFTWARE_PROVIDER_NAME,
        FROM_SOFTWARE_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/42/200/200",
        "60fps!"
    ),
    GifsPackDao(10, null, listOf(), FROM_SOFTWARE_PROVIDER_NAME, FROM_SOFTWARE_PROVIDER_IMAGE_URL, "https://picsum.photos/id/52/200/200"),
    // CD Projekt Red
    GifsPackDao(
        11,
        "The Witcher 2",
        listOf(),
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/13/200/200"
    ),
    GifsPackDao(
        12,
        "The Witcher 3",
        listOf(),
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/23/200/200",
        "Silver Swords"
    ),
    GifsPackDao(
        13,
        "Cyberpunk 2077",
        listOf(),
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/33/200/200"
    ),
    GifsPackDao(
        14,
        "The Witcher 3",
        listOf(),
        CD_PROJEKT_RED_PROVIDER_NAME,
        CD_PROJEKT_RED_PROVIDER_IMAGE_URL,
        "https://picsum.photos/id/43/200/200",
        "The Wild Hunt Best Of Eredin"
    ),
    // Team Cherry
    GifsPackDao(15, "Zote", listOf(), TEAM_CHERRY_PROVIDER_NAME, imageUrl = "https://picsum.photos/id/14/200/200"),
    GifsPackDao(
        16,
        null,
        listOf(),
        TEAM_CHERRY_PROVIDER_NAME,
        "",
        "https://picsum.photos/id/24/200/200",
        "Road to Hallownest - Run through Forgotten Crossroads"
    ),
    GifsPackDao(17, "Cornifer", listOf(), TEAM_CHERRY_PROVIDER_NAME, imageUrl = "https://picsum.photos/id/34/200/200"),
    GifsPackDao(
        18,
        "Pantheon",
        listOf(),
        TEAM_CHERRY_PROVIDER_NAME,
        imageUrl = "https://picsum.photos/id/44/200/200",
        description = "Most awesome combos"
    )
)
