package com.paragramm.mobile_paragramm.data.repository.client

import com.paragramm.mobile_paragramm.data.repository.resource.AuthRequest
import com.paragramm.mobile_paragramm.data.repository.resource.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/auth")
    fun auth(@Body auth: AuthRequest): Call<AuthResponse>

}