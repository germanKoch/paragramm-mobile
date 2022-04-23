package com.paragramm.mobile_paragramm.presentation.conversation.component

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.domain.auth.UserDetails
import com.paragramm.mobile_paragramm.usecase.ConversationsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ConversationsViewModel : ViewModel() {

    private val useCase: ConversationsUseCase = ConversationsUseCase()

    val _conversations: LiveData<List<Conversation>> = useCase.getAll(UserDetails.USER_ID)

    init {
        runBlocking {
            insertData()
        }
    }

    suspend fun insertData() {
        val data = listOf(
            Conversation(
                title = "German Kochnev",
                picture = "picture",
            ),
            Conversation(
                title = "Kseniia Tochenykhx",
                picture = "picture",
            ),
            Conversation(
                title = "Nekto Nektovich",
                picture = "picture",
            ),
            Conversation(
                title = "Lala Topola",
                picture = "picture",
            ),
            Conversation(
                title = "Otvolgi Doenisea",
                picture = "picture",
            ),
            Conversation(
                title = "Bus' Busivich",
                picture = "picture",
            ),
            Conversation(
                title = "Yopta Yoptovich",
                picture = "picture",
            ),
        )
        data.forEach {
            useCase.save(it)
        }
    }

}

class ConversationsViewModelFactory() :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ConversationsViewModel() as T

}