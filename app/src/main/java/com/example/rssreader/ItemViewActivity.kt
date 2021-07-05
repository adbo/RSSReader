package com.example.rssreader

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class ItemViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_view)

        val extras = intent.extras
        val url = extras!!.getString("url")

        val webView: WebView = findViewById(R.id.webView)
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}