package com.example.sampleretrofitapp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val rf: Retrofit = Retrofit.Builder()
            .baseUrl(BirdsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()


        val birdsApi = rf.create(BirdsApi::class.java)
        val call: Call<ArrayList<BirdsList?>?>? = birdsApi.geBirdsData()
        call?.enqueue(object : Callback<ArrayList<BirdsList?>?> {
            override fun onResponse(
                call: Call<ArrayList<BirdsList?>?>?,
                response: Response<ArrayList<BirdsList?>?>
            ) {
                val birdsLists = response.body()
                val birdsAdapter = BirdsAdapter(applicationContext, R.layout.birds_list, birdsLists)
                listView.adapter = birdsAdapter
            }

            override fun onFailure(call: Call<ArrayList<BirdsList?>?>?, t: Throwable?) {}
        })

    }

}