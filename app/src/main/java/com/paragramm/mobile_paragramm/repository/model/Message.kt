package com.paragramm.mobile_paragramm.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "message")
data class Message(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "conversationId") val conversationId: Long,
    @ColumnInfo(name = "sender") val senderId: Long?,
    @ColumnInfo(name = "text") val text: String?,
    @ColumnInfo(name = "creationDate") val creationDate: ZonedDateTime
)
