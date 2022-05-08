package com.paragramm.mobile_paragramm.repository.network

import com.paragramm.mobile_paragramm.config.LOGIN
import com.paragramm.mobile_paragramm.config.PASSWORD
import com.paragramm.mobile_paragramm.repository.exceptions.NetworkException
import com.paragramm.mobile_paragramm.repository.model.Conversation
import com.paragramm.mobile_paragramm.repository.network.resource.AuthRequest
import com.paragramm.mobile_paragramm.repository.network.retrofit.AuthClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.ConversationClient
import com.paragramm.mobile_paragramm.repository.network.retrofit.NetworkService
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import kotlin.properties.Delegates

class NetworkAuthService {

    private val client: AuthClient = NetworkService.client()

    fun test(): Observable<Response<MutableList<Conversation>>> {
        val client = NetworkService.client<ConversationClient>()
        return getToken().flatMap {
            client.getAllConversations(it)
        }
    }


    fun <T> withAuth(request: (token: String) -> Observable<Response<T>>): Observable<T> {
        return getToken().flatMap {
            request(it)
        }.flatMap { response ->
            return@flatMap if (response.isSuccessful) {
                Observable.just(response.body())
            } else if (isTokenExpired(response)) {
                refreshToken().flatMap { request(it) }.map {
                    if (it.isSuccessful) {
                        it.body()
                    } else {
                        throw NetworkException("Response status: ${it.code()}")
                    }
                }
            } else {
                throw NetworkException("Response status: ${response.code()}")
            }
        }.subscribeOn(Schedulers.io()).map {
            it!!
        }
    }

    private fun getToken(): Observable<String> {
        return Observable.just(token)
    }

    private fun refreshToken(): Observable<String> {
        return client.auth(AuthRequest(LOGIN, PASSWORD)).doOnEach {
            if (it.value == null || !it.value!!.isSuccessful || it.value!!.body() == null) {
                throw NetworkException("Authorization exception")
            }
            token = it.value!!.body()!!.token
        }.map { token }
    }

    private fun isTokenExpired(response: Response<out Any?>): Boolean {
        return response.code() in 401..403
    }

    companion object {
        //TODO: is it thread safe
        @Volatile
        private var token = "test"
    }

}