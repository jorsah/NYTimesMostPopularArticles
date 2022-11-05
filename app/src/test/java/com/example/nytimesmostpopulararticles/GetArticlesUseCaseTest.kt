package com.example.nytimesmostpopulararticles

import com.example.nytimesmostpopulararticles.data.remote.model.Model
import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import com.example.nytimesmostpopulararticles.domain.GetArticlesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call

@RunWith(JUnit4::class)
class GetArticlesUseCaseTest {

    private val repoMock = mockk<ArticlesRepository>()
    private val callMock = mockk<Call<Model>>()

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