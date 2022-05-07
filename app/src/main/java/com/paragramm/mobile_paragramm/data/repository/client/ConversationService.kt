package com.paragramm.mobile_paragramm.data.repository.client

import com.paragramm.mobile_paragramm.data.model.Conversation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ConversationService {

    @GET("/api/conversation")
    fun getAllConversations(@Header("Authorization") token: String): Call<MutableList<Conversation>>

    @GET("/api/conversation/after/{lastId}")
    fun getConversationsAfterLast(
        @Header("Authorization") token: String,
        @Path("lastId") lastId: Long
    ): Call<MutableList<Conversation>>

}