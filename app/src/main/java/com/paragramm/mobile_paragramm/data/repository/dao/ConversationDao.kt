package com.paragramm.mobile_paragramm.data.repository.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.paragramm.mobile_paragramm.data.model.Conversation
import com.paragramm.mobile_paragramm.data.model.Message

@Dao
interface ConversationDao {

    @Insert
    fun insertAll(conversations: MutableList<Conversation>)

    @Query("SELECT * FROM conversation")
    fun getAll(): LiveData<List<Conversation>>

    @Delete
    fun delete(conversation: Conversation)

}