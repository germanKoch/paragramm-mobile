package com.paragramm.mobile_paragramm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.network.ConversationNetworkRepository

class ConversationsViewModel : ViewModel() {

    val _conversations: MutableLiveData<List<Conversation>> = MutableLiveData()

    init {
        val networkRepo = ConversationNetworkRepository()
        networkRepo.getAllConversations().subscribe(
            {
                _conversations.postValue(it)
            },
            {
                Log.e("NETWORK ERROR", it.toString())
            }
        )
    }

}

class ConversationsViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ConversationsViewModel() as T

}