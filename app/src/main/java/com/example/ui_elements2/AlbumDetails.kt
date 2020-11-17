package com.example.ui_elements2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.core.content.ContextCompat
import java.util.*

class AlbumDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        //Get the intents from the previous activity
        val uri = intent.getStringExtra("imageUri")
        val songsToBeDisplayed = intent.getStringArrayListExtra("songs")

        //Convert the intent into array because it is a type of Array List
        var songsArray = songsToBeDisplayed!!.toTypedArray()

        //Mapping the ImageView
        val AlbumCover = findViewById<ImageView>(R.id.albumCover)
        //Mapping the List View
        val albumDetailsListView = findViewById<ListView>(R.id.albumDetailsListView)

        //Replacing the current source of the Image view using the URI
        var imageResource = getResources().getIdentifier(uri, null, getPackageName()) //Gets the resource using the URI
        var res = getResources().getDrawable(imageResource) //Converting the image resource into a drawable file
        AlbumCover.setImageDrawable(res) //Attach/set the drawable to the Image view

        //Attach the adapter to the list view
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        albumDetailsListView.adapter = adapter

        Log.i("try", songsToBeDisplayed.toString())

    }
}
