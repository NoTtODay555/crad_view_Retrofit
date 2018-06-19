package com.example.napat.cardview_retrofit.interactor

import android.util.Log
import com.example.napat.cardview_retrofit.Model.Movie
import com.example.napat.cardview_retrofit.Model.Result
import com.example.napat.cardview_retrofit.Model.Network.Retrofit
import com.example.napat.cardview_retrofit.presenter.ConstutorPrecenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class interactor(val presenter : ConstutorPrecenter.main): ConstutorInteractor.GetApi {
    var a: List<Result>? = null
    override fun gettitalSearch( titleSearch: String) {
        var listMovie: List<Result>?
        listMovie = ArrayList()
//        for (i in 0 ..(a?.size ?: 0)){
//            Log.e("time",i.toString())
//            if (titleSearch.contentEquals(a?.get(i)?.title!!)) {
//                Log.e("test",listMovie.toString())
//                listMovie.add(a!![i])
//            }
//        }
            for (i in 0 ..((a?.size ?: 0)-1)) {
                if(titleSearch.toLowerCase() in a!![i].title!!.toLowerCase()) {
                    listMovie.add(a!![i])
                    Log.e("listMovietime", i.toString())
                }
            }
        Log.e("Ok",listMovie.toString())
        presenter.getListdata(listMovie)
    }


    override fun getApi() {
        Retrofit().getApi()?.getMovie()?.enqueue(object : Callback<Movie>{
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                presenter.getListdata(response?.body()?.results)
                a = response?.body()?.results
            }

        })
    }
}