package com.oy.taipeizoo.network.response

import com.google.gson.annotations.SerializedName
import com.oy.taipeizoo.network.model.AnimalDto

data class AnimalResponse(
    @SerializedName("result")
    var result: ResultInfo
)
data class ResultInfo(
    @SerializedName("limit")
    var limit:Int,
    @SerializedName("offset")
    var offset:Int,
    @SerializedName("count")
    var count:Int,
    @SerializedName("results")
    var animals:List<AnimalDto>
)