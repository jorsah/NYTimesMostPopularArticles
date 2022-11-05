package com.example.nytimesmostpopulararticles.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesmostpopulararticles.app.utill.Result
import com.example.nytimesmostpopulararticles.domain.GetArticlesUseCase
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesListViewModel @Inject constructor(private val getArticlesUseCase: GetArticlesUseCase) :
    ViewModel() {
    private val _articlesListLiveData = MutableLiveData<Result<List<ArticleEntity>?>>()
    val articlesListLiveData: LiveData<Result<List<ArticleEntity>?>>
        get() = _articlesListLiveData

    fun requestArticles() {
        _articlesListLiveData.postValue(Result.Loading())
        viewModelScope.launch {
            _articlesListLiveData.postValue(getArticlesUseCase()!!)
        }
    }
}