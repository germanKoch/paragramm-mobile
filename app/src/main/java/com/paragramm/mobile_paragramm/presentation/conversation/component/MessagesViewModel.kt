package com.paragramm.mobile_paragramm.presentation.conversation.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.config.BACKEND_URL
import com.paragramm.mobile_paragramm.data.repository.client.AuthService
import com.paragramm.mobile_paragramm.data.repository.client.MessageService
import com.paragramm.mobile_paragramm.data.repository.client.RetrofitClient
import com.paragramm.mobile_paragramm.data.repository.database.ParagrammDatabase
import com.paragramm.mobile_paragramm.presentation.conversation.component.mediator.MessageRemoteMediator
import com.paragramm.mobile_paragramm.usecase.ConversationDetailsUseCase
import retrofit2.Retrofit

class MessagesViewModel constructor(
    conversationId: Long
) : ViewModel() {

    private val useCase: ConversationDetailsUseCase = ConversationDetailsUseCase()

    @ExperimentalPagingApi
    val _messages = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 20,
            enablePlaceholders = true,
            maxSize = 10000
        ),
        remoteMediator = MessageRemoteMediator(
            RetrofitClient.getClient().create(AuthService::class.java),
            RetrofitClient.getClient().create(MessageService::class.java),
            ParagrammDatabase.getDatabase(ParagrammApplication.context)
        )
    ) {
        useCase.getMessagesPaged(conversationId)
    }.flow

}

class ConversationDetailsViewModelFactory(val conversationId: Long) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MessagesViewModel(conversationId) as T

}

