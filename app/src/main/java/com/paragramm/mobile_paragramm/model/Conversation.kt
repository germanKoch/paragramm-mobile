package com.paragramm.mobile_paragramm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversation")
data class Conversation(
    @PrimaryKey val id: Long?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "picture") val picture: String?,
)
