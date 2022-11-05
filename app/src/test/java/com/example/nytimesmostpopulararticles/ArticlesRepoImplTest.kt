package com.example.nytimesmostpopulararticles

import com.example.nytimesmostpopulararticles.app.utill.Result
import com.example.nytimesmostpopulararticles.data.ArticlesRepositoryImpl
import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import com.example.nytimesmostpopulararticles.data.remote.model.ArticleModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ArticlesRepoImplTest {
    private val service = mockk<RetrofitServices>()
    val list = listOf<ArticleModel>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test api call`() = runTest {
        coEvery { service.getArticlesList(any()) } returns mockk()
        coEvery { service.getArticlesList(any()).isSuccessful } returns true
        coEvery { service.getArticlesList(any()).body()?.results } returns list
        val repository = ArticlesRepositoryImpl(service)
        assertEquals(repository.getArticles(), Result.Success(list))
    }

}