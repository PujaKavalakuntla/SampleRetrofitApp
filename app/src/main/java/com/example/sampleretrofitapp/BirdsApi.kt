package com.example.sampleretrofitapp

import retrofit2.Call
import retrofit2.http.GET
import java.util.*


interface BirdsApi {

    @GET("birdsdata.php")
    fun geBirdsData(): Call<ArrayList<BirdsList?>?>?

    companion object {
        const val BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/"
    }
}