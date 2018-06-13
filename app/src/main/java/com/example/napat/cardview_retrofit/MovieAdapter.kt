package com.example.napat.cardview_retrofit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cardview_movie.view.*

class MovieAdapter (var context: Context): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
//    private var listMovie: List<Result> = listOf() // List
    var movielist = ArrayList<Result>()     // ArrayList
    fun setMovies(data: List<Result>) {
        movielist.addAll(data)      // add List in array
//        listMovie = data    //  list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movielist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindData(movielist[position])
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBindData(list: Result?) {
            Glide.with(itemView.context).load(list?.imageUrl).into(itemView.iv_image_url)
            itemView.tv_title.text = list?.title
            itemView.setOnClickListener {
                    context.startActivity(Intent(context,
                                                    ViewMovieActivity::class.java)
                                                    .putExtra("Movie",list))
            }
        }
    }
}
