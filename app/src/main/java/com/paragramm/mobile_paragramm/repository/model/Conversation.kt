package com.paragramm.mobile_paragramm.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "conversation")
data class Conversation(
    @PrimaryKey var id: Long,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "picture") val picture: String?,
    @ColumnInfo(name = "creationDate") val creationDate: ZonedDateTime
)
