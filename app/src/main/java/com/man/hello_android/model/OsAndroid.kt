package com.man.hello_android.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 07, August, 2019
 */
data class OsAndroid (val name : String?,
                      val version : String?,
                      val release_date : String?,
                      val api_level : String?,
                      val icon : String?,
                      val new_feature : String?,
                      val description : String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(version)
        parcel.writeString(release_date)
        parcel.writeString(api_level)
        parcel.writeString(icon)
        parcel.writeString(new_feature)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OsAndroid> {
        override fun createFromParcel(parcel: Parcel): OsAndroid {
            return OsAndroid(parcel)
        }

        override fun newArray(size: Int): Array<OsAndroid?> {
            return arrayOfNulls(size)
        }
    }
}