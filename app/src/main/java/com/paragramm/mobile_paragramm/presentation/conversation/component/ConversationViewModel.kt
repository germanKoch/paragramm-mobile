package com.paragramm.mobile_paragramm.presentation.conversation.component

import androidx.lifecycle.*
import com.paragramm.mobile_paragramm.config.LOGIN
import com.paragramm.mobile_paragramm.config.PASSWORD
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.repository.client.AuthService
import com.paragramm.mobile_paragramm.data.repository.client.ConversationService
import com.paragramm.mobile_paragramm.data.repository.client.RetrofitClient
import com.paragramm.mobile_paragramm.data.repository.resource.AuthRequest
import com.paragramm.mobile_paragramm.usecase.ConversationsUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class ConversationsViewModel : ViewModel() {

    private val useCase: ConversationsUseCase = ConversationsUseCase()

    val _conversations: LiveData<List<Conversation>>

    init {
        val client = RetrofitClient.getClient().create(ConversationService::class.java)
        val auth = RetrofitClient.getClient().create(AuthService::class.java)
        _conversations = MutableLiveData()

        thread {
            val token = auth.auth(
                AuthRequest(LOGIN, PASSWORD)
            ).execute().body()!!.token
            _conversations.postValue(client.getAllConversations(token).execute().body()!!)
        }
    }

}

class ConversationsViewModelFactory() :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ConversationsViewModel() as T

}