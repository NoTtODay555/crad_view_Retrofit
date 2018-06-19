package com.example.napat.cardview_retrofit.interactor

import com.example.napat.cardview_retrofit.Model.Result

interface ConstutorInteractor{
    interface GetApi{
        fun getApi()
        fun gettitalSearch(titleSearch : String)
    }
}