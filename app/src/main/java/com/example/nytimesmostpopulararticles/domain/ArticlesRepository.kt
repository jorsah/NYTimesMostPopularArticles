package com.example.nytimesmostpopulararticles.domain

import com.example.nytimesmostpopulararticles.data.remote.model.Model
import retrofit2.Call

interface ArticlesRepository {
    suspend fun getArticles(): Call<Model>
}