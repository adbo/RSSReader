package com.example.rssreader.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "item", strict = false)
data class RssItem @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String? = null,

    @field:Element(name = "link")
    @param:Element(name = "link")
    val link: String? = null,

    @field:Element(name = "description")
    @param:Element(name = "description")
    val description: String? = null,

    @field:Element(name = "enclosure")
    @param:Element(name = "enclosure")
    val enclosure: RssImage? = null,

    @field:Element(name = "pubDate")
    @param:Element(name = "pubDate")
    val pubDate: String? = null
)