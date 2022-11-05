package com.example.nytimesmostpopulararticles.helpers

import com.example.nytimesmostpopulararticles.app.utill.Result
import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject


class FakeDataRepoImpl @Inject constructor() : ArticlesRepository {
    override suspend fun getArticles(): Result<List<ArticleEntity>> = withContext(Dispatchers.Main){
        delay(2000)
        Result.Success(
            listOf(
                ArticleEntity(
                    "",
                    "",
                    "15.15.2022",
                    "By Test",
                    "",
                    "TEST",
                    "",
                    null
                )
            )
        )
    }

}
