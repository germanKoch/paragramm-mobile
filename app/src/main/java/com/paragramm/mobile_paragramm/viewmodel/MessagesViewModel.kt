package com.paragramm.mobile_paragramm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.paragramm.mobile_paragramm.repository.network.retrofit.AuthClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.MessagesClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.NetworkService
import com.paragramm.mobile_paragramm.repository.database.ParagrammDatabase
import com.paragramm.mobile_paragramm.viewmodel.mediator.MessageRemoteMediator

class MessagesViewModel constructor(
    conversationId: Long
) : ViewModel() {

    private val db = ParagrammDatabase.getDatabase()

    @ExperimentalPagingApi
    val _messages = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 20,
            enablePlaceholders = true,
            maxSize = 10000
        ),
        remoteMediator = MessageRemoteMediator()
    ) {
        db.messageDao().getMessagesPaged(conversationId)
    }.flow

}

class ConversationDetailsViewModelFactory(val conversationId: Long) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MessagesViewModel(conversationId) as T

}

