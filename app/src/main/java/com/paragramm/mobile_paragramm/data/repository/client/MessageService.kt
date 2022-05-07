package com.paragramm.mobile_paragramm.data.repository.client

import com.paragramm.mobile_paragramm.data.model.Message
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MessageService {

    @GET("/api/message/{conversationId}")
    fun getAllMessages(@Header("Authorization") token: String, @Path("conversationId") conversationId: Long): Call<MutableList<Message>>

    @GET("/api/message/{conversationId}/after/{lastId}")
    fun getMessagesAfterLast(@Header("Authorization") token: String, @Path("conversationId") conversationId: Long, @Path("lastId") lastId: Long): Call<MutableList<Message>>


}