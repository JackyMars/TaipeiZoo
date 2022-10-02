package com.oy.taipeizoo.network.response

import com.google.gson.annotations.SerializedName
import com.oy.taipeizoo.network.model.AnimalLocationDto


data class AnimalLocationReponse(
    @SerializedName("result")
    var result: LocationResultInfo
)
data class LocationResultInfo(
    @SerializedName("limit")
    var limit:Int,
    @SerializedName("offset")
    var offset:Int,
    @SerializedName("count")
    var count:Int,
    @SerializedName("results")
    var locations:List<AnimalLocationDto>
)