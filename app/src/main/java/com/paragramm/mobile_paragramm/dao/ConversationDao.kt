package com.paragramm.mobile_paragramm.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.paragramm.mobile_paragramm.model.Conversation
import com.paragramm.mobile_paragramm.model.ConversationWithMessage

@Dao
interface ConversationDao {

    @Query("SELECT * FROM conversation")
    fun getAll(): List<Conversation>

    @Query("SELECT * FROM conversation WHERE id=:id")
    fun getById(id: Long): ConversationWithMessage

    @Insert
    fun insertAll(vararg conversations: Conversation)

    @Delete
    fun delete(conversation: Conversation)

}