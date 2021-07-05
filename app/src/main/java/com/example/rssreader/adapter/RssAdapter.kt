package com.example.rssreader

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rssreader.data.RssItem

class RssAdapter(private val feeds: List<RssItem>): RecyclerView.Adapter<RssViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rss_item, parent, false)
        return RssViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feeds.size
    }

    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        return holder.bind(feeds[position])
    }
}

class RssViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo: ImageView = itemView.findViewById(R.id.feed_photo)
    private val title: TextView = itemView.findViewById(R.id.feed_title)
    private val description: TextView = itemView.findViewById(R.id.feed_description)

    fun bind(item: RssItem) {
        Glide.with(itemView.context).load(item.enclosure?.url).into(photo)
        title.text = item.title
        description.text = item.description?.let { item.description.substring(it.indexOf(">")+1) }
        itemView.setOnClickListener {
            val intent = Intent(it.context, ItemViewActivity::class.java)
            intent.putExtra("url", item.link)
            it.context.startActivity(intent)
        }
    }

}