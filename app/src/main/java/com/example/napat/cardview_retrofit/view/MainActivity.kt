package com.example.napat.cardview_retrofit.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.napat.cardview_retrofit.Model.Movie
import com.example.napat.cardview_retrofit.Model.Result
import com.example.napat.cardview_retrofit.Model.Retrofit
import com.example.napat.cardview_retrofit.R
import com.example.napat.cardview_retrofit.presenter.ConstutorPrecenter
import com.example.napat.cardview_retrofit.presenter.Precenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),ConstutorView.Movieja  {
    override fun getData(a: List<Result>) {
        Log.e("test",a.toString())
        movieAdapter.setMovies(a)
    }
    val presenter : ConstutorPrecenter.main = Precenter(this)
    private var movieAdapter : MovieAdapter = MovieAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getApi()
        rv_movie?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }


    }

    }


