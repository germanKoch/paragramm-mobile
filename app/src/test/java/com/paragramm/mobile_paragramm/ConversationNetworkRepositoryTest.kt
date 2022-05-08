package com.paragramm.mobile_paragramm

import android.util.Log
import com.paragramm.mobile_paragramm.config.LOGIN
import com.paragramm.mobile_paragramm.config.PASSWORD
import com.paragramm.mobile_paragramm.repository.network.ConversationNetworkRepository
import com.paragramm.mobile_paragramm.repository.network.NetworkAuthService
import com.paragramm.mobile_paragramm.repository.network.resource.AuthRequest
import com.paragramm.mobile_paragramm.repository.network.retrofit.AuthClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.ConversationClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.NetworkService
import org.junit.Test

class ConversationNetworkRepositoryTest {

    @Test
    fun test1() {
        val token =
            "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnZXJtS28iLCJpYXQiOjE2NTIwMzIyMTAsImV4cCI6MTY1MjAzNTgxMH0.wXAkc-f1sQsfyyTgvRqffpFwH3lLwMt6GvDh8X_zBFI"
        println(
            NetworkService.client<ConversationClient>().getAllConversations(token).blockingFirst()
        )
    }


    @Test
    fun test2() {
        println(ConversationNetworkRepository().getAllConversations().blockingFirst())
//        val auth = NetworkAuthService()
//        auth.test().doOnEach {
//            print(it)
//        }.blockingFirst()
    }

}