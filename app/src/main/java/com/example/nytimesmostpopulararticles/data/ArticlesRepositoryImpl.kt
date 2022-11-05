package com.example.nytimesmostpopulararticles.data

import com.example.nytimesmostpopulararticles.app.utill.Result
import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesRepositoryImpl @Inject constructor(
    private val restInterface: RetrofitServices,
) : ArticlesRepository {

    override suspend fun getArticles(): Result<List<ArticleEntity>> = withContext(Dispatchers.IO) {
        val result = restInterface.getArticlesList()
        if (result.isSuccessful)
            return@withContext Result.Success(result.body()!!.results.map { it.toEntity() })
        Result.Failure(result.message(), null)
    }
}