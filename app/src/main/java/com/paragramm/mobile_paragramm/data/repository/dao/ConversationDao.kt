package com.paragramm.mobile_paragramm.data.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.model.ConversationWithMessage
import com.paragramm.mobile_paragramm.data.model.Message

@Dao
interface ConversationDao {

    @Insert
    suspend fun insertAll(vararg conversations: Conversation)

    @Insert
    suspend fun insertAll(vararg message: Message)

    @Query("SELECT * FROM conversation")
    fun getAll(): LiveData<List<Conversation>>

    @Query("SELECT * FROM conversation WHERE id=:id")
    fun getById(id: Long): LiveData<ConversationWithMessage>

    @Delete
    fun delete(conversation: Conversation)

}