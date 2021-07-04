package com.example.rssreader.data

import com.example.rssreader.data.RssItem
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "channel", strict = false)
data class RssChannel @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String? = null,

    @field:ElementList(name = "item", inline = true, required = false)
    var item: List<RssItem>? = null
)