package com.example.rssreader.data

import com.example.rssreader.data.RssFeed
import retrofit2.Call
import retrofit2.http.GET


interface RssService {
    @GET("pub/rss/wiadomosci_kraj.htm")
    fun getFeed(): Call<RssFeed>
}