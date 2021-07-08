package com.example.rssreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val actionbar = supportActionBar
        actionbar!!.title = "Favorites"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}