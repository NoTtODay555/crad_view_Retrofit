package com.example.napat.cardview_retrofit.presenter

import com.example.napat.cardview_retrofit.Model.Result
import com.example.napat.cardview_retrofit.interactor.ConstutorInteractor
import com.example.napat.cardview_retrofit.interactor.interactor
import com.example.napat.cardview_retrofit.view.ConstutorView

class Precenter (val view : ConstutorView.Movieja): ConstutorPrecenter.main {
    val interActior : ConstutorInteractor.GetApi = interactor(this)
    override fun getListdata(a: List<Result>?) {
        a?.let { view.getData(it) }
    }

    override fun getApi() {
        interActior.getapi()
    }
}