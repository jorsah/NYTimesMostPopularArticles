package com.example.nytimesmostpopulararticles.domain

import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import com.example.nytimesmostpopulararticles.app.utill.Result

interface ArticlesRepository {
    suspend fun getArticles(): Result<List<ArticleEntity>>
}