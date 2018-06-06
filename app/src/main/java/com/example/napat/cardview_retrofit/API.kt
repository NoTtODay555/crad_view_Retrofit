package com.example.napat.cardview_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("movie")
    fun getMovie():  Call<Movie>
}