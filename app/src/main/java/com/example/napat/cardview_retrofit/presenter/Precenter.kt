package com.example.napat.cardview_retrofit.presenter

import android.util.Log
import com.example.napat.cardview_retrofit.Model.Result
import com.example.napat.cardview_retrofit.interactor.ConstutorInteractor
import com.example.napat.cardview_retrofit.interactor.interactor
import com.example.napat.cardview_retrofit.view.ConstutorView

class Precenter (val view : ConstutorView.Movieja): ConstutorPrecenter.main {
    override fun getsearch(titelchar: String) {
        Log.e("getsearch", titelchar)
        interActior.gettitalSearch(titelchar)
    }

    val interActior : ConstutorInteractor.GetApi = interactor(this)
    override fun getListdata(a: List<Result>?) {
        a?.let { view.getData(it) }

    }

    override fun getApi() {
        interActior.getApi()
    }
}