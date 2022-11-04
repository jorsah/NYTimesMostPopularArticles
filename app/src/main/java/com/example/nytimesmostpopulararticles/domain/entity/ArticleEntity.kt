package com.example.nytimesmostpopulararticles.domain.entity

import com.example.nytimesmostpopulararticles.data.remote.model.Media

data class ArticleEntity(
    val uri: String,
    val url: String,
    val publishedDate: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val media: Media? = null
)
