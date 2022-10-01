package com.oy.taipeizoo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimalLocationInfo (
    val id:Int,
    val no:Int,
    val category:String?=null,
    val name:String?=null
): Parcelable