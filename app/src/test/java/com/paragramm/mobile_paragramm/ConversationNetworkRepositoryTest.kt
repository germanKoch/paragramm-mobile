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
        NetworkService.client<AuthClient>().auth(AuthRequest(LOGIN, PASSWORD)).subscribe {
            print("test: ${it}")
        }
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