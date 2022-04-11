package com.paragramm.mobile_paragramm.service

import com.paragramm.mobile_paragramm.model.Conversation
import javax.inject.Inject

class ConversationService @Inject constructor() {

    fun getAll(userId: Long?): List<Conversation> {
        return listOf(
            Conversation(
                id = 1L,
                title = "German Kochnev",
                picture = "picture",
            ),
            Conversation(
                id = 2L,
                title = "Kseniia Tochenykh",
                picture = "picture",
            ),
            Conversation(
                id = 3L,
                title = "Nekto Nektovich",
                picture = "picture",
            ),
            Conversation(
                id = 4L,
                title = "Lala Topola",
                picture = "picture",
            ),
            Conversation(
                id = 5L,
                title = "Otvolgi Doenisea",
                picture = "picture",
            ),
            Conversation(
                id = 6L,
                title = "Bus' Busivich",
                picture = "picture",
            ),
            Conversation(
                id = 7L,
                title = "Yopta Yoptovich",
                picture = "picture",
            ),
        )
    }

}