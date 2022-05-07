package com.paragramm.mobile_paragramm.data.repository.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.paragramm.mobile_paragramm.data.model.Message

@Dao
interface MessageDao {

    @Insert
    fun insertAll(messages: MutableList<Message>)

    //TODO: order by timestamp
    @Query("SELECT * FROM message WHERE conversationId=:conversationId ORDER BY id")
    fun getMessagesPaged(conversationId: Long): PagingSource<Int, Message>

}