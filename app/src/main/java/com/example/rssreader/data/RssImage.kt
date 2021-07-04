package com.example.rssreader.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "enclosure")
data class RssImage @JvmOverloads constructor(
    @field:Attribute(name = "url")
    @param:Attribute(name = "url")
    val url: String? = null,

    @field:Attribute(name = "length")
    @param:Attribute(name = "length")
    val length: String? = null,

    @field:Attribute(name = "type")
    @param:Attribute(name = "type")
    val type: String? = null
)