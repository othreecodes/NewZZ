package com.envelope.pickyapp.data.api

import com.envelope.pickyapp.data.dto.Interest
import com.envelope.pickyapp.data.dto.NewsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers

interface PickyService {


    @Headers("content-type: application/json")
    @GET("interest")
    fun getInterests():Call<List<Interest>>
}