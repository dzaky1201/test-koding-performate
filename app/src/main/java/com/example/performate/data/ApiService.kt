package com.example.performate.data

import com.example.performate.data.model.PhoneResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("exec")
    suspend fun getPhoneData(
        @Query("action") action: String = "getDataPhone"
    ): List<PhoneResponseItem>
}