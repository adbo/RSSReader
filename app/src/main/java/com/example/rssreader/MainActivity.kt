package com.example.rssreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rssreader.data.RssFeed
import com.example.rssreader.data.RssService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(RssService::class.java)
        val call = request.getFeed()

        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val mainTitle: TextView = findViewById(R.id.mainTitle)

        call.enqueue(object : Callback<RssFeed>{
            override fun onResponse(call: Call<RssFeed>, response: Response<RssFeed>) {
                if (response.isSuccessful){
                    progressBar.visibility = View.GONE
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = response.body()!!.channel?.item?.let { RssAdapter(it) }
                    }
                    mainTitle.text = response.body()!!.channel?.title;
                }
            }
            override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                val title : TextView = findViewById(R.id.mainTitle)
                title.text = t.toString()
            }
        })

    }
}