package com.example.nytimesmostpopulararticles.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.app.adapter.ArticlesRecyclerViewAdapter
import com.example.nytimesmostpopulararticles.app.utill.Result
import com.example.nytimesmostpopulararticles.app.viewmodel.ArticlesListViewModel
import com.example.nytimesmostpopulararticles.app.viewmodel.ArticlesSharedViewModel
import com.example.nytimesmostpopulararticles.databinding.FragmentArticleListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleListFragment @Inject constructor() : Fragment() {

    private val binding: FragmentArticleListBinding by lazy {
        FragmentArticleListBinding.inflate(
            layoutInflater
        )
    }
    private val sharedViewModel: ArticlesSharedViewModel by activityViewModels()
    private val viewModel: ArticlesListViewModel by viewModels()
    private val articleAdapter = ArticlesRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.requestArticles()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initRecyclerView()
        viewModel.articlesListLiveData.observe(requireActivity()) {
            when (it) {
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    articleAdapter.setArticles(it.value)
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_LONG)
                        .show()
                }
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
        return binding.root
    }

    private fun initRecyclerView() {
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
            articleAdapter.setOnItemClickListener { article ->
                sharedViewModel.selectArticle(article)
                findNavController().navigate(R.id.action_articleListFragment_to_articleFragment)
            }
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }
}