package com.oy.taipeizoo.network

import com.oy.taipeizoo.network.response.AnimalResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire")
    suspend fun search(@Query("q") q:String,
                       @Query("offset") offset:Int,
                       @Query("limit") limit:Int): AnimalResponse
}