package com.example.nytimesmostpopulararticles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nytimesmostpopulararticles.app.utill.BASE_URL
import com.example.nytimesmostpopulararticles.data.ArticlesRepositoryImpl
import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class RetrofitClientTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val server = MockWebServer()
    private lateinit var repository: ArticlesRepository
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    @Before
    fun init() {

        server.start(8000)
        val BASE_URL = server.url("/").toString()

        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(RetrofitServices::class.java)

        repository = ArticlesRepositoryImpl(service)
    }

    @Test
    fun testRetrofitInstance() {
        val instance: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        assert(instance.baseUrl().toString() == BASE_URL)
    }

    @Test
    suspend fun testGetArticles() {
        //Execute the API call
        val response = repository.getArticles().execute()
        //Check for error body
        val errorBody = response.errorBody()
        assert(errorBody == null)
        //Check for success body
        val responseWrapper = response.body()
        assert(responseWrapper != null)
        assert(response.code() == 200)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}