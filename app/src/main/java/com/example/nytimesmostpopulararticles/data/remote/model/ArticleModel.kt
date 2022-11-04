package com.example.nytimesmostpopulararticles.data.remote.model

import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import com.google.gson.annotations.SerializedName

data class ArticleModel(
    val uri: String,
    val url: String,
    @SerializedName("published_date")
    val publishedDate: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val geoFacet: ArrayList<String> = arrayListOf(),
    val media: ArrayList<Media?>? = arrayListOf(),
) {
    fun toEntity(): ArticleEntity {
        val mediaEntity = if (media.isNullOrEmpty()) null else media?.get(0)
        return ArticleEntity(
            uri,
            url,
            publishedDate,
            byline,
            type,
            title,
            abstract,
            mediaEntity
        )
    }

    fun fromEntity(entity: ArticleEntity): ArticleModel {
        with(entity) {
            return ArticleModel(
                uri,
                url,
                publishedDate,
                byline,
                title,
                type,
                abstract,
                geoFacet,
                arrayListOf(media)
            )
        }
    }
}