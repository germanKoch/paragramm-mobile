package com.paragramm.mobile_paragramm.usecase

import androidx.lifecycle.LiveData
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.repository.database.ParagrammDatabase

class ConversationsUseCase {

    val db = ParagrammDatabase.getDatabase(ParagrammApplication.context)

    fun getAll(userId: Long?): LiveData<List<Conversation>> {
        return db.conversationDao().getAll()
    }

    suspend fun save(conversation: Conversation) {
        db.conversationDao().insertAll(conversation)
    }

}