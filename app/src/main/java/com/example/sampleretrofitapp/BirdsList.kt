package com.example.sampleretrofitapp

import com.google.gson.annotations.SerializedName

class BirdsList {
    @SerializedName("id")
    var id = 0

    @SerializedName("birds_image")
    var birdsImageUrl: String? = null

    @SerializedName("birds_name")
    var birdsName: String? = null
}
