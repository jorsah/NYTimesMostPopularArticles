package com.example.nytimesmostpopulararticles

import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import com.example.nytimesmostpopulararticles.domain.GetArticlesUseCase
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.example.nytimesmostpopulararticles.app.utill.Result

@RunWith(JUnit4::class)
class GetArticlesUseCaseTest {

    private val repoMock = mockk<ArticlesRepository>()
    private val callMock = mockk<Result<List<ArticleEntity>>>()

    @Before
    fun setup() {
        coEvery { repoMock.getArticles() } returns callMock
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test get articles function`() = runTest {
        val getArticlesUseCase = GetArticlesUseCase(repoMock)
        assert(getArticlesUseCase() == callMock)
    }

}