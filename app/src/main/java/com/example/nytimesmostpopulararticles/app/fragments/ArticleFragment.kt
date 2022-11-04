package com.example.nytimesmostpopulararticles.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.nytimesmostpopulararticles.databinding.FragmentArticleBinding
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity
import com.example.nytimesmostpopulararticles.app.viewmodel.ArticlesSharedViewModel

class ArticleFragment : Fragment() {
    private val binding: FragmentArticleBinding by lazy {
        FragmentArticleBinding.inflate(layoutInflater)
    }
    private val viewModel: ArticlesSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.selectedArticle.observe(requireActivity()) { article ->
            initView(article)
        }
        return binding.root
    }

    private fun initView(article: ArticleEntity) {
        with(binding) {
            title.text = article.title
            url.text = article.url
            abstractText.text = article.abstract
            type.text = article.type
            article.media?.let {
                binding.mediaCaption.text = it.caption
                if (isAdded) {
                    Glide.with(this@ArticleFragment)
                        .load(it.mediaMetadata.last().url)
                        .into(articleImage)
                }
            }
        }
    }

}