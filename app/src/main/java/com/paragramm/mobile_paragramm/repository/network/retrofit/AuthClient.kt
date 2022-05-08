package com.paragramm.mobile_paragramm.repository.network.retrofit

import com.paragramm.mobile_paragramm.repository.network.resource.AuthRequest
import com.paragramm.mobile_paragramm.repository.network.resource.AuthResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthClient {

    @POST("/api/auth")
    fun auth(@Body auth: AuthRequest): Observable<Response<AuthResponse>>

}