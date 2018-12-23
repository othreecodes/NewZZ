package com.envelope.pickyapp.data.api

import android.content.Context
import com.envelope.pickyapp.data.dto.Interest
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PickyHttp(context:Context){
    val BASE_URL = ""

    var retrofit: Retrofit
    var service:PickyService

    init {
        val build = GsonBuilder()
        .setLenient()
        .create()
        this.retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(build))
//            .client(httpClient.build())
            .build()
        this.service = this.retrofit.create(PickyService::class.java)
    }

      fun getInterests() = service.getInterests()

}