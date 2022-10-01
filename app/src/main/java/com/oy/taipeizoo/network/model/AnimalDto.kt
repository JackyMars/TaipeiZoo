package com.oy.taipeizoo.network.model

import com.google.gson.annotations.SerializedName

data class AnimalDto (
    @SerializedName("_id")
    var _id:Int,
    @SerializedName("a_name_ch")
    var a_name_ch:String,
    @SerializedName("a_location")
    var a_location:String,
    @SerializedName("a_phylum")
    var a_phylum:String,
    @SerializedName("a_class")
    var a_class:String,
    @SerializedName("a_order")
    var a_order:String,
    @SerializedName("a_family")
    var a_family:String,
    @SerializedName("a_distribution")
    var a_distribution:String,
    @SerializedName("a_feature")
    var a_feature:String,
    @SerializedName("a_behavior")
    var a_behavior:String,
    @SerializedName("a_diet")
    var a_diet:String,
    @SerializedName("a_pic01_url")
    var a_pic01_url:String
)