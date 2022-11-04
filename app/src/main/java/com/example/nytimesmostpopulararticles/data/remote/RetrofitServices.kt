package com.example.nytimesmostpopulararticles.data.remote

import com.example.nytimesmostpopulararticles.BuildConfig
import com.example.nytimesmostpopulararticles.data.remote.model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("viewed/7.json?")
    fun getArticlesList(@Query("api-key") apiKey: String = BuildConfig.API_KEY): Call<Model>
}