package com.paragramm.mobile_paragramm.usecase

import androidx.paging.PagingSource
import com.paragramm.mobile_paragramm.ParagrammApplication
import com.paragramm.mobile_paragramm.data.model.Message
import com.paragramm.mobile_paragramm.data.repository.database.ParagrammDatabase
import java.time.ZonedDateTime
import kotlin.concurrent.thread

class ConversationDetailsUseCase {

    private val db = ParagrammDatabase.getDatabase(ParagrammApplication.context)

    fun save(message: Message) {
        db.messageDao().insertAll(mutableListOf(message))
    }

    fun getMessagesPaged(conversationId: Long): PagingSource<Int, Message> {
        return db.messageDao().getMessagesPaged(conversationId)
    }

}
