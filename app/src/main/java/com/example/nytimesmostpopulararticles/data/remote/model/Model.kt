
package com.example.nytimesmostpopulararticles.data.remote.model

data class Model (
    var status: String,
    var copyright: String,
    var num_results: Int,
    var results: List<ArticleModel>
)