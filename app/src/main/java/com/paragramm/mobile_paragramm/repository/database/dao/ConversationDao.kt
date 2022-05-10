package com.paragramm.mobile_paragramm.repository.database.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.paragramm.mobile_paragramm.repository.model.Conversation

@Dao
interface ConversationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(conversations: MutableList<Conversation>)

    @Query("SELECT * FROM conversation ORDER BY id")
    fun getConversations(): PagingSource<Int, Conversation>

    @Delete
    fun delete(conversation: Conversation)

}