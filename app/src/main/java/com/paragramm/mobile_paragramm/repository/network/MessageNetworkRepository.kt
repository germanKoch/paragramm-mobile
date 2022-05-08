package com.paragramm.mobile_paragramm.repository.network

import com.paragramm.mobile_paragramm.repository.model.Message
import com.paragramm.mobile_paragramm.repository.network.retrofit.MessagesClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.NetworkService
import io.reactivex.Observable

class MessageNetworkRepository {

    private val auth: NetworkAuthService = NetworkAuthService()
    private val client: MessagesClient = NetworkService.client()

    fun getAllMessages(conversationId: Long): Observable<MutableList<Message>> {
        return auth.withAuth {
            client.getAllMessages(it, conversationId)
        }
    }

    fun getMessagesAfter(conversationId: Long, lastId: Long): Observable<MutableList<Message>> {
        return auth.withAuth {
            client.getMessagesAfterLast(it, conversationId, lastId)
        }
    }
}