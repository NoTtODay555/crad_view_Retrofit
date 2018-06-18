package com.example.napat.cardview_retrofit.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.napat.cardview_retrofit.Model.Result
import com.example.napat.cardview_retrofit.R
import kotlinx.android.synthetic.main.activity_viewmovie.*

class ViewMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmovie)
        val movieList = intent.extras.getParcelable<Result>("Movie")
        val title  = movieList.title
        val imageUrl = movieList.imageUrl
        val overView = movieList.overView
        title_view.text = title
        Glide.with(this).load(imageUrl).into(Image_View)
        overview_view.text = overView
    }
}
