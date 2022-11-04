package com.example.nytimesmostpopulararticles.data.remote.model

import com.google.gson.annotations.SerializedName

data class Media(
    val type: String,
    var subtype: String,
    var caption: String,
    var copyright: String,
    @SerializedName("approved_for_syndication")
    var approvedForSyndication: Int,
    @SerializedName("media-metadata")
    var mediaMetadata: ArrayList<MediaMetadata> = arrayListOf()

)