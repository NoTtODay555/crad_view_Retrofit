package com.example.napat.cardview_retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var movieAdapter : MovieAdapter = MovieAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_movie?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
        Retrofit().getapi().getMovie()
                .enqueue(object : Callback<Movie>{
                    override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                        if (response?.isSuccessful == true){
                            movieAdapter.setMovies(response.body()?.results!!)
                        }else{
                            // TODO: handle message error
                        }
                    }
                    override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                        t?.printStackTrace()
                    }
                })

    }

    }


