package com.paragramm.mobile_paragramm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "conversationId") val conversationId: Long,
    @ColumnInfo(name = "sender") val sender: String?,
    @ColumnInfo(name = "text") val text: String?
)
