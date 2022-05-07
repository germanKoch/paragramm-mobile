package com.paragramm.mobile_paragramm.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.repository.client.ConversationService
import com.paragramm.mobile_paragramm.data.repository.client.RetrofitClient
import com.paragramm.mobile_paragramm.data.repository.database.ParagrammDatabase

class ConversationsUseCase {

    val db = ParagrammDatabase.getDatabase(ParagrammApplication.context)

    fun getAll(): LiveData<List<Conversation>> {
        return db.conversationDao().getAll()
    }

    fun save(conversation: Conversation) {
        db.conversationDao().insertAll(mutableListOf(conversation))
    }

}