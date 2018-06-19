package com.example.napat.cardview_retrofit.Model.Network

import com.example.napat.cardview_retrofit.Model.Network.BaseUrl.Companion.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    private fun retrofit (baseUrl : String): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getApi(): Api? = retrofit(baseUrl).create(Api::class.java)
}