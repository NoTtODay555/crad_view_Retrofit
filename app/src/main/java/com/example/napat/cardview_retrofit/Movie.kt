package com.example.napat.cardview_retrofit

import com.google.gson.annotations.SerializedName


data class Movie(
   @SerializedName("results") val results: List<Result>? = null
)

data class Result(
        @SerializedName("title")val title: String? = null,
        @SerializedName("image_url")val image_url: String? = null,
        @SerializedName("overview")val overview: String? = null
)