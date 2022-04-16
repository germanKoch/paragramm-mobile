package com.paragramm.mobile_paragramm.usecase

import androidx.lifecycle.LiveData
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.data.model.ConversationWithMessage
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.data.repository.database.ParagrammDatabase

class ConversationDetailsUseCase {

    private val db = ParagrammDatabase.getDatabase(ParagrammApplication.context)

    fun save(message: Message) {
        db.conversationDao().insertAll(message)
    }

    fun getById(id: Long, userId: Long): LiveData<ConversationWithMessage> {
        return db.conversationDao().getById(id)
    }

}
