package com.paragramm.mobile_paragramm.model

import androidx.room.*

@Entity
data class ConversationWithMessage(
    @Embedded
    val conversation: Conversation,
    @Relation(parentColumn = "id", entityColumn = "conversationId")
    val messages: List<Message>
)
