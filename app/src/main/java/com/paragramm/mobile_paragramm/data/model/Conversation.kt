package com.paragramm.mobile_paragramm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversation")
data class Conversation(
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "picture") val picture: String?,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
