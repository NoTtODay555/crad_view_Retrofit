package com.example.napat.cardview_retrofit.interactor

import com.example.napat.cardview_retrofit.Model.Movie
import com.example.napat.cardview_retrofit.Model.Retrofit
import com.example.napat.cardview_retrofit.presenter.ConstutorPrecenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class interactor(val presenter : ConstutorPrecenter.main): ConstutorInteractor.GetApi {
    override fun getapi() {
        Retrofit().getApi()?.getMovie()?.enqueue(object : Callback<Movie>{
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                presenter.getListdata(response?.body()?.results)
            }

        })
    }
}