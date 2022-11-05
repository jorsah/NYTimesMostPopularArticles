package com.example.nytimesmostpopulararticles.domain

import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import javax.inject.Inject
import com.example.nytimesmostpopulararticles.app.utill.Result

class GetArticlesUseCase @Inject constructor(private val repository: ArticlesRepository) {
    suspend operator fun invoke(): Result<List<ArticleEntity>> {
        return repository.getArticles()
    }
}