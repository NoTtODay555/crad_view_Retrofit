package com.example.napat.cardview_retrofit.Model.Network

import com.example.napat.cardview_retrofit.Model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movie")
    fun getMovie():  Call<Movie>
}