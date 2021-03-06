package com.example.napat.cardview_retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_viewmovie.*

class ViewMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmovie)
//        val bundle = intent.getBundleExtra("BUNDLE")
//        val movieList = bundle.getParcelable<Result>("Movie")
        val movieList = intent.extras.getParcelable<Result>("Movie")
        val title  = movieList.title
        val imageUrl = movieList.imageUrl
        val overView = movieList.overView
        title_view.text = title
        Glide.with(this).load(imageUrl).into(Image_View)
        overview_view.text = overView
    }
}
