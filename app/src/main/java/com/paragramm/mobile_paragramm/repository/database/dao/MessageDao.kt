package com.paragramm.mobile_paragramm.repository.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paragramm.mobile_paragramm.repository.model.Message

@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(messages: MutableList<Message>)

    //TODO: order by timestamp
    @Query("SELECT * FROM message WHERE conversationId=:conversationId ORDER BY id")
    fun getMessages(conversationId: Long): PagingSource<Int, Message>

}