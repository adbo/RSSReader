package com.example.rssreader.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
data class RssFeed @JvmOverloads constructor(
    @field:Element(name="channel")
    var channel: RssChannel? = null
)