package com.example.napat.cardview_retrofit

import android.os.Parcel
import android.os.Parcelable

data class Model_Movie(var title : String,var image_url : String,var overview : String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(image_url)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Model_Movie> {
        override fun createFromParcel(parcel: Parcel): Model_Movie {
            return Model_Movie(parcel)
        }

        override fun newArray(size: Int): Array<Model_Movie?> {
            return arrayOfNulls(size)
        }
    }


}