package com.example.fragmentaston.recyclerView

import android.os.Parcel
import android.os.Parcelable

data class User(
    val photo: Int,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(photo)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(phoneNumber)
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}