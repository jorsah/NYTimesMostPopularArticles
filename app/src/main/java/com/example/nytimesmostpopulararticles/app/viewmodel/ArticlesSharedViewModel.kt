package com.example.nytimesmostpopulararticles.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesSharedViewModel @Inject constructor() : ViewModel() {
    private val _selectedArticle = MutableLiveData<ArticleEntity>()
    val selectedArticle: LiveData<ArticleEntity>
        get() = _selectedArticle

    fun selectArticle(article: ArticleEntity) {
        _selectedArticle.postValue(article)
    }
}