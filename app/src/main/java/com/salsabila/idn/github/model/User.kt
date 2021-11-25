package com.salsabila.idn.github.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name : String?,
    var username : String?,
    var photo : Int ,
    var followers : Int?,
    var following : Int?,
    var company : String?,
    var repository : Int?,
    var location : String?
) : Parcelable