package com.paragramm.mobile_paragramm.service

import com.paragramm.mobile_paragramm.model.Conversation
import com.paragramm.mobile_paragramm.model.ConversationWithMessage
import com.paragramm.mobile_paragramm.model.Message
import com.paragramm.mobile_paragramm.model.exceptions.NotFoundException
import javax.inject.Inject

class ConversationDetailsService @Inject constructor() {

    fun getById(id: Long, userId: Long): ConversationWithMessage {
        return data[id] ?: throw NotFoundException("Conversation not found")
    }

    companion object {
        val data = mapOf(
            1L to ConversationWithMessage(
                conversation = Conversation(
                    id = 1L,
                    title = "German Kochnev",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 1L, "German Kochnev", "Hello!"),
                    Message(2L, 1L, "German Kochnev", "Hello!"),
                    Message(3L, 1L, "German Kochnev", "Hello!"),
                    Message(4L, 1L, "German Kochnev", "Hello!"),
                    Message(5L, 1L, "German Kochnev", "Hello!"),
                    Message(6L, 1L, "German Kochnev", "Hello!"),
                    Message(7L, 1L, "German Kochnev", "Hello!"),
                    Message(8L, 1L, "German Kochnev", "Hello!"),
                    Message(9L, 1L, "German Kochnev", "Hello!"),
                    Message(10L, 1L, "German Kochnev", "Hello!"),
                    Message(11L, 1L, "German Kochnev", "Hello!"),
                    Message(12L, 1L, "German Kochnev", "Hello!")
                )
            ),
            2L to ConversationWithMessage(
                conversation = Conversation(
                    id = 2L,
                    title = "Kseniia Tochenykh",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 2L, "German Kochnev", "Hello!"),
                    Message(2L, 2L, "German Kochnev", "Hello!"),
                    Message(3L, 2L, "German Kochnev", "Hello!"),
                    Message(4L, 2L, "German Kochnev", "Hello!"),
                    Message(5L, 2L, "German Kochnev", "Hello!"),
                    Message(6L, 2L, "German Kochnev", "Hello!"),
                    Message(7L, 2L, "German Kochnev", "Hello!"),
                    Message(8L, 2L, "German Kochnev", "Hello!"),
                    Message(9L, 2L, "German Kochnev", "Hello!"),
                    Message(10L, 2L, "German Kochnev", "Hello!"),
                    Message(11L, 2L, "German Kochnev", "Hello!"),
                    Message(12L, 2L, "German Kochnev", "Hello!")
                )
            ),
            3L to ConversationWithMessage(
                conversation = Conversation(
                    id = 3L,
                    title = "Nekto Nektovich",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 3L, "German Kochnev", "Hello!"),
                    Message(2L, 3L, "German Kochnev", "Hello!"),
                    Message(3L, 3L, "German Kochnev", "Hello!"),
                    Message(4L, 3L, "German Kochnev", "Hello!"),
                    Message(5L, 3L, "German Kochnev", "Hello!"),
                    Message(6L, 3L, "German Kochnev", "Hello!"),
                    Message(7L, 3L, "German Kochnev", "Hello!"),
                    Message(8L, 3L, "German Kochnev", "Hello!"),
                    Message(9L, 3L, "German Kochnev", "Hello!"),
                    Message(10L, 3L, "German Kochnev", "Hello!"),
                    Message(11L, 3L, "German Kochnev", "Hello!"),
                    Message(12L, 3L, "German Kochnev", "Hello!")
                )
            ),
            4L to ConversationWithMessage(
                conversation = Conversation(
                    id = 4L,
                    title = "Lala Topola",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 4L, "German Kochnev", "Hello!"),
                    Message(2L, 4L, "German Kochnev", "Hello!"),
                    Message(3L, 4L, "German Kochnev", "Hello!"),
                    Message(4L, 4L, "German Kochnev", "Hello!"),
                    Message(5L, 4L, "German Kochnev", "Hello!"),
                    Message(6L, 4L, "German Kochnev", "Hello!"),
                    Message(7L, 4L, "German Kochnev", "Hello!"),
                    Message(8L, 4L, "German Kochnev", "Hello!"),
                    Message(9L, 4L, "German Kochnev", "Hello!"),
                    Message(10L, 4L, "German Kochnev", "Hello!"),
                    Message(11L, 4L, "German Kochnev", "Hello!"),
                    Message(12L, 4L, "German Kochnev", "Hello!")
                )
            ),
            5L to ConversationWithMessage(
                conversation = Conversation(
                    id = 5L,
                    title = "Otvolgi Doenisea",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 5L, "German Kochnev", "Hello!"),
                    Message(2L, 5L, "German Kochnev", "Hello!"),
                    Message(3L, 5L, "German Kochnev", "Hello!"),
                    Message(4L, 5L, "German Kochnev", "Hello!"),
                    Message(5L, 5L, "German Kochnev", "Hello!"),
                    Message(6L, 5L, "German Kochnev", "Hello!"),
                    Message(7L, 5L, "German Kochnev", "Hello!"),
                    Message(8L, 5L, "German Kochnev", "Hello!"),
                    Message(9L, 5L, "German Kochnev", "Hello!"),
                    Message(10L, 5L, "German Kochnev", "Hello!"),
                    Message(11L, 5L, "German Kochnev", "Hello!"),
                    Message(12L, 5L, "German Kochnev", "Hello!")
                )
            ),
            6L to ConversationWithMessage(
                conversation = Conversation(
                    id = 6L,
                    title = "Bus' Busivich",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 6L, "German Kochnev", "Hello!"),
                    Message(2L, 6L, "German Kochnev", "Hello!"),
                    Message(3L, 6L, "German Kochnev", "Hello!"),
                    Message(4L, 6L, "German Kochnev", "Hello!"),
                    Message(5L, 6L, "German Kochnev", "Hello!"),
                    Message(6L, 6L, "German Kochnev", "Hello!"),
                    Message(7L, 6L, "German Kochnev", "Hello!"),
                    Message(8L, 6L, "German Kochnev", "Hello!"),
                    Message(9L, 6L, "German Kochnev", "Hello!"),
                    Message(10L, 6L, "German Kochnev", "Hello!"),
                    Message(11L, 6L, "German Kochnev", "Hello!"),
                    Message(12L, 6L, "German Kochnev", "Hello!")
                )
            ),
            7L to ConversationWithMessage(
                conversation = Conversation(
                    id = 7L,
                    title = "Yopta Yoptovich",
                    picture = "picture",

                    ),
                messages = listOf(
                    Message(1L, 7L, "German Kochnev", "Hello!"),
                    Message(2L, 7L, "German Kochnev", "Hello!"),
                    Message(3L, 7L, "German Kochnev", "Hello!"),
                    Message(4L, 7L, "German Kochnev", "Hello!"),
                    Message(5L, 7L, "German Kochnev", "Hello!"),
                    Message(6L, 7L, "German Kochnev", "Hello!"),
                    Message(7L, 7L, "German Kochnev", "Hello!"),
                    Message(8L, 7L, "German Kochnev", "Hello!"),
                    Message(9L, 7L, "German Kochnev", "Hello!"),
                    Message(10L, 7L, "German Kochnev", "Hello!"),
                    Message(11L, 7L, "German Kochnev", "Hello!"),
                    Message(12L, 7L, "German Kochnev", "Hello!")
                )
            ),
        )
    }

}
