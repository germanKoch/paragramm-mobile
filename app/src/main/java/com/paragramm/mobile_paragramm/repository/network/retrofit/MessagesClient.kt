package com.paragramm.mobile_paragramm.repository.network.retrofit

import com.paragramm.mobile_paragramm.repository.model.Message
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MessagesClient {

    @GET("/api/message/{conversationId}")
    fun getAllMessages(
        @Header("Authorization") token: String,
        @Path("conversationId") conversationId: Long
    ): Observable<Response<MutableList<Message>>>

    @GET("/api/message/{conversationId}/after/{lastId}")
    fun getMessagesAfterLast(
        @Header("Authorization") token: String,
        @Path("conversationId") conversationId: Long,
        @Path("lastId") lastId: Long
    ): Observable<Response<MutableList<Message>>>


}