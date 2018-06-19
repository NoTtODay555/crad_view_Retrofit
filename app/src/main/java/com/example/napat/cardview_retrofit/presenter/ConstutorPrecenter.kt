package com.example.napat.cardview_retrofit.presenter

import com.example.napat.cardview_retrofit.Model.Result

interface ConstutorPrecenter{
    interface main{
        fun getApi()
        fun getListdata(a: List<Result>?)
        fun getsearch(titelchar : String)
    }
}