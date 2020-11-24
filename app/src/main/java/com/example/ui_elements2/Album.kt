package com.example.ui_elements2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView

var albumSongs = ArrayList<String>()
var albumURI = String

class Album : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        val GridView = findViewById<GridView>(R.id.gridView) as GridView

        GridView.adapter = ImageAdapter(applicationContext)

        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, AlbumDetails::class.java)
            var uri: String
            if (position == 0) {
                uri = "@drawable/divide_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.cb))
            } else if (position == 1) {
                uri = "@drawable/abbey_road_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.neyo))
            } else {
                uri = "@drawable/scorpion_cover"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.usher))
            }
            intent.putExtra("imageUri",  uri)
            startActivity(intent)


        }



    }




}


