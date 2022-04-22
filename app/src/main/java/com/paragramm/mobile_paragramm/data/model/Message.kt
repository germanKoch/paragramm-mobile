package com.paragramm.mobile_paragramm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message")
data class Message(
    @ColumnInfo(name = "conversationId") val conversationId: Long,
    @ColumnInfo(name = "sender") val senderId: Long?,
    @ColumnInfo(name = "text") val text: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
