package com.oy.taipeizoo.network

import com.oy.taipeizoo.network.response.AnimalLocationReponse
import com.oy.taipeizoo.network.response.AnimalResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire")
    suspend fun search(@Query("q") q:String,
                       @Query("offset") offset:Int,
                       @Query("limit") limit:Int): AnimalResponse

    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun getLocation(): AnimalLocationReponse
}