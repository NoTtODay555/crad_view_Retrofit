package com.example.napat.cardview_retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.cardview_movie.view.*

class test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val bundle = intent.getBundleExtra("MyBundle")
        var Movielist = bundle.getParcelable<Result>("Movie_list")
        val title  = Movielist.title
        val image_url = Movielist.image_url
        val overview = Movielist.overview
        title_view.text = title
        Glide.with(this).load(image_url).into(Image_View)
        overview_view.text = overview

    }
}
