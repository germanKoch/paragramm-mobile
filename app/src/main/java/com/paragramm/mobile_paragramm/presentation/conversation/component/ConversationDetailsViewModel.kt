package com.paragramm.mobile_paragramm.presentation.conversation.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.model.ConversationWithMessage
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.domain.auth.UserDetails
import com.paragramm.mobile_paragramm.usecase.ConversationDetailsUseCase
import kotlinx.coroutines.runBlocking

class ConversationDetailsViewModel constructor(
    conversationId: Long
) : ViewModel() {

    private val useCase: ConversationDetailsUseCase = ConversationDetailsUseCase()

    val _conversation: LiveData<ConversationWithMessage> =
        useCase.getById(conversationId, UserDetails.USER_ID)

//    suspend fun insertData() {
//        data.forEach { (_, value) ->
//            value.messages.forEach {
//                useCase.save(it)
//            }
//        }
//    }

    companion object {
        val data = mapOf(
            1L to ConversationWithMessage(
                conversation = Conversation(
                    title = "German Kochnev",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!"),
                    Message(1L, "German Kochnev", "Hello!")
                )
            ),
            2L to ConversationWithMessage(
                conversation = Conversation(
                    title = "Kseniia Tochenykh",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!"),
                    Message(2L, "German Kochnev", "Hello!")
                )
            ),
            3L to ConversationWithMessage(
                conversation = Conversation(
                    title = "Nekto Nektovich",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!"),
                    Message(3L, "German Kochnev", "Hello!")
                )
            ),
            4L to ConversationWithMessage(
                conversation = Conversation(
                    title = "Lala Topola",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!"),
                    Message(4L, "German Kochnev", "Hello!")
                )
            ),
            5L to ConversationWithMessage(
                conversation = Conversation(
                    title = "Otvolgi Doenisea",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!"),
                    Message(5L, "German Kochnev", "Hello!")
                )
            ),
            6L to ConversationWithMessage(
                conversation = Conversation(
                    title = "Bus' Busivich",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!"),
                    Message(6L, "German Kochnev", "Hello!")
                )
            ),
            7L to ConversationWithMessage(
                conversation = Conversation(
                    title = "Yopta Yoptovich",
                    picture = "picture",
                ),
                messages = listOf(
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!"),
                    Message(7L, "German Kochnev", "Hello!")
                )
            ),
        )
    }

}

class ConversationDetailsViewModelFactory(val conversationId: Long) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ConversationDetailsViewModel(conversationId) as T

}

