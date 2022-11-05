package com.example.nytimesmostpopulararticles

import com.example.nytimesmostpopulararticles.data.ArticlesRepositoryImpl
import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import com.example.nytimesmostpopulararticles.data.remote.model.Model
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call

@RunWith(JUnit4::class)
class ArticlesRepoImplTest {
    private val service = mockk<RetrofitServices>()
    private val callMock = mockk<Call<Model>>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test api call`() = runTest {
        coEvery { service.getArticlesList(any()) } returns callMock
        val repository = ArticlesRepositoryImpl(service)

        assertEquals(repository.getArticles(), callMock)
    }

}