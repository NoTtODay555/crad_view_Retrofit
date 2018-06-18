package com.example.napat.cardview_retrofit.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    private fun retrofit (): Retrofit = Retrofit.Builder()
            .baseUrl("https://workshopup.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getApi(): Api? = retrofit().create(Api::class.java)
}