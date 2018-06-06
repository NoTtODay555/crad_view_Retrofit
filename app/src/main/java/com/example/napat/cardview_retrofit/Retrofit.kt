package com.example.napat.cardview_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Movie {
    private fun retrofit (): Retrofit = Retrofit.Builder()
            .baseUrl("https://workshopup.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getapi() = retrofit().create(API ::class.java)
}