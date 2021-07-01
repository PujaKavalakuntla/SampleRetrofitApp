package com.example.sampleretrofitapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.*


class BirdsAdapter(context: Context, resource: Int, birdsLists: ArrayList<BirdsList?>?) :
    ArrayAdapter<BirdsList?>(context, resource, birdsLists as List<BirdsList?>) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val layoutInflater =
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.birds_list, null, true)
        }
        val birdsList = getItem(position)
        val img = convertView!!.findViewById<View>(R.id.birdsImg) as ImageView
        val textView = convertView.findViewById<View>(R.id.birdsName) as TextView
        Glide.with(context).load(birdsList!!.birdsImageUrl).into(img)
        textView.text = birdsList.birdsName
        return convertView
    }
}