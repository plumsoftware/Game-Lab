package com.example.gamelab.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Game(
    val id: Int,
    val price: Int,
    val name: String,
    val logoResId: Int,
    val genre: String
) : Parcelable, Serializable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(price)
        parcel.writeString(name)
        parcel.writeInt(logoResId)
        parcel.writeString(genre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Game> {
        override fun createFromParcel(parcel: Parcel): Game {
            return Game(parcel)
        }

        override fun newArray(size: Int): Array<Game?> {
            return arrayOfNulls(size)
        }
    }
}
