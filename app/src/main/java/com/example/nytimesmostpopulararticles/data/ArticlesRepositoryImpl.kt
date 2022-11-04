package com.example.nytimesmostpopulararticles.data

import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesRepositoryImpl @Inject constructor(
    private val restInterface: RetrofitServices,
) : ArticlesRepository {

    override suspend fun getArticles() = withContext(Dispatchers.IO) {
        restInterface.getArticlesList()
    }
}