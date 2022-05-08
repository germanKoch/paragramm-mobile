package com.paragramm.mobile_paragramm.repository.network

import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.network.retrofit.ConversationClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.NetworkService
import io.reactivex.Observable

class ConversationNetworkRepository {

    private val auth: NetworkAuthService = NetworkAuthService()
    private val client: ConversationClient = NetworkService.client()

    fun getAllConversations(): Observable<MutableList<Conversation>> {
        return auth.withAuth {
            client.getAllConversations(it)
        }
    }

    fun getConversationsAfterLast(lastId: Long): Observable<MutableList<Conversation>> {
        return auth.withAuth {
            client.getConversationsAfterLast(it, lastId)
        }
    }

}