package com.paragramm.mobile_paragramm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.paragramm.mobile_paragramm.repository.database.ParagrammDatabase
import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.network.ConversationNetworkRepository
import com.paragramm.mobile_paragramm.viewmodel.mediator.ConversationRemoteMediator

class ConversationsViewModel : ViewModel() {

    private val db = ParagrammDatabase.getDatabase()

    @ExperimentalPagingApi
    val _conversations = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 20,
            enablePlaceholders = true,
            maxSize = 10000
        ),
        remoteMediator = ConversationRemoteMediator()
    ) {
        db.conversationDao().getConversations()
    }.flow

}

class ConversationsViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ConversationsViewModel() as T

}