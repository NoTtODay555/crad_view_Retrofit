package com.example.napat.cardview_retrofit.Model

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movie")
    fun getMovie():  Call<Movie>
}