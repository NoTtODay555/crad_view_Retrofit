package com.example.napat.cardview_retrofit.Model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Movie(
   @SerializedName ("results") val results: List<Result>? = null
)

data class Result(
        @SerializedName("title")val title: String? = null,
        @SerializedName("image_url")val imageUrl: String? = null,
        @SerializedName("overview")val overView: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(imageUrl)
        parcel.writeString(overView)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}