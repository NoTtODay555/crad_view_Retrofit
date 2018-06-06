package com.example.napat.cardview_retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import retrofit2.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cardview_movie.view.*
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var movieAdapter : MovieAdapter = MovieAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        rv_movie?.layoutManager = LinearLayoutManager(this@MainActivity)
//        rv_movie?.adapter = movieAdapter
        //s
        rv_movie?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }

        Retrofit_Movie.getapi().getMovie()
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


