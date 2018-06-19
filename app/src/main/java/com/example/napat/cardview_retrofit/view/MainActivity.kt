package com.example.napat.cardview_retrofit.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.napat.cardview_retrofit.Model.Result
import com.example.napat.cardview_retrofit.R
import com.example.napat.cardview_retrofit.presenter.ConstutorPrecenter
import com.example.napat.cardview_retrofit.presenter.Precenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ConstutorView.Movieja  {
    override fun getData(a: List<Result>) {
        Log.e("Movielist", a.toString())
        movieAdapter.setMovies(a)
    }
    val presenter : ConstutorPrecenter.main = Precenter(this)
    private var movieAdapter : MovieAdapter = MovieAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getApi()
        buttonSerachMovie.setOnClickListener {
            Log.e("button","Ok")
            presenter.getsearch(ev_serachmovie.text.toString())
        }
        ev_serachmovie.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.getsearch(ev_serachmovie.text.toString())
            }
        })
        rv_movie?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }


    }

    }


