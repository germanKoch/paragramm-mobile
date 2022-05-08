package com.paragramm.mobile_paragramm.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.paragramm.mobile_paragramm.repository.model.Conversation

@Dao
interface ConversationDao {

    @Insert
    fun insertAll(conversations: MutableList<Conversation>)

    @Query("SELECT * FROM conversation")
    fun getAll(): LiveData<List<Conversation>>

    @Delete
    fun delete(conversation: Conversation)

}