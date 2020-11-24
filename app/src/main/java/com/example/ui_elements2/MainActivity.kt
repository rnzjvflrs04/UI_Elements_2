package com.example.ui_elements2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar

val queuedSongs = ArrayList<String>() //Array where all the songs queued will be stored and will be passed to the Queue activity
val songsArray = arrayListOf<String>()
class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            songsArray.addAll(resources.getStringArray(R.array.cb))
            songsArray.addAll(resources.getStringArray(R.array.neyo))
            songsArray.addAll(resources.getStringArray(R.array.usher))


            var songsListView  = findViewById<ListView>(R.id.songsListView)

            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
            songsListView.adapter = adapter


            registerForContextMenu(songsListView)

        }

        override fun onCreateContextMenu(
                menu: ContextMenu?,
                v: View?,
                menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            super.onCreateContextMenu(menu, v, menuInfo)
            val inflater: MenuInflater = menuInflater
            inflater.inflate(R.menu.optionsmenu, menu)
        }

        override fun onContextItemSelected(item: MenuItem): Boolean {
            val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo //Allows us to inherit from the class Adapterview.AdapterCOntextMenuInfo to get the position
            return when (item.itemId) {
                R.id.add_song_to_queue -> {
                    queuedSongs.add(songsArray[menuInfo.position])
                    val snackbar = Snackbar.make(findViewById(R.id.songsListView), "${songsArray[menuInfo.position]} is added to the Queue.", Snackbar.LENGTH_LONG)
                    snackbar.setAction("Queue", View.OnClickListener { //Lamda function
                        val intent = Intent(this, Queue::class.java)
                        startActivity(intent)
                    })
                    snackbar.show()
                    true
                }
                else -> {
                    return super.onContextItemSelected(item)
                }

            }

        }



        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.mainmenu, menu)
            return super.onCreateOptionsMenu(menu)
            return true
        }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId){
                R.id.go_to_songs -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.go_to_album -> {
                    startActivity(Intent(this, Album::class.java))
                    true
                }
                R.id.go_to_queue -> {
                    val intent = Intent(this, Queue::class.java)
                    startActivity(intent)
                    true
                }
                else -> super.onOptionsItemSelected(item)

            }


        }
    }