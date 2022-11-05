package com.example.nytimesmostpopulararticles.data.remote

import com.example.nytimesmostpopulararticles.BuildConfig
import com.example.nytimesmostpopulararticles.data.remote.model.Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("viewed/7.json?")
    suspend fun getArticlesList(@Query("api-key") apiKey: String = BuildConfig.API_KEY): Response<Model>
}