package com.example.napat.cardview_retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import retrofit2.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        rv_movie?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }

        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("https://workshopup.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val apiaries = retrofit.create(API ::class.java)

        apiaries.getMovie()
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
    inner class MovieAdapter :RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
        private var listMovie : List<Result> = listOf()
        fun setMovies(data: List<Result>) {

            listMovie = data
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie, parent, false))
        }

        override fun getItemCount(): Int {
            return listMovie.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
            holder.onBindData(listMovie[position])
        }

        inner class ViewHolder (view : View): RecyclerView.ViewHolder(view){
            fun onBindData(list: Result?) {

                Glide.with(itemView.context).load(list?.image_url).into(itemView.iv_image_url)
                itemView.tv_title.text = list?.title
            }


        }


    }
    }

