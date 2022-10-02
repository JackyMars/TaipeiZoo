package com.oy.taipeizoo.network.model

import com.google.gson.annotations.SerializedName

data class AnimalLocationDto (
    @SerializedName("_id")
    var _id:Int,
    @SerializedName("e_no")
    var e_no:Int,
    @SerializedName("e_category")
    var e_category:String,
    @SerializedName("e_name")
    var e_name:String,
)