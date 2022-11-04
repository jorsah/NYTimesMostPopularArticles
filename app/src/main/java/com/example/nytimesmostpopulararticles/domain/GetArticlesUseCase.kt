package com.example.nytimesmostpopulararticles.domain

import com.example.nytimesmostpopulararticles.data.remote.model.Model
import retrofit2.Call
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val repository: ArticlesRepository) {
    suspend operator fun invoke(): Call<Model> {
        return repository.getArticles()
    }
}