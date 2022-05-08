package com.paragramm.mobile_paragramm.repository.network.retrofit

import com.paragramm.mobile_paragramm.repository.model.Conversation
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ConversationClient {

    @GET("/api/conversation")
    fun getAllConversations(@Header("Authorization") token: String): Observable<Response<MutableList<Conversation>>>

    @GET("/api/conversation/after/{lastId}")
    fun getConversationsAfterLast(
        @Header("Authorization") token: String,
        @Path("lastId") lastId: Long
    ): Observable<Response<MutableList<Conversation>>>

}