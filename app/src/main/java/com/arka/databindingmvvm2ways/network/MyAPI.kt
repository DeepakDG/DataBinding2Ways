package com.arka.databindingmvvm2ways.network

import com.arka.databindingmvvm2ways.model.Photo
import com.arka.databindingmvvm2ways.util.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MyAPI {

    @GET("photos/{id}")
    fun getPhoto(
        @Path("id") id: Int
    ): Call<Photo>

    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }
}