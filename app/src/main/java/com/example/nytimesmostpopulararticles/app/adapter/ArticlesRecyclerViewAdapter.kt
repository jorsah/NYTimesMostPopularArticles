package com.example.nytimesmostpopulararticles.app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.databinding.FragmentArticleListItemBinding
import com.example.nytimesmostpopulararticles.domain.entity.ArticleEntity

class ArticlesRecyclerViewAdapter : RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ViewHolder>() {
    private var values = listOf<ArticleEntity>()
    private var itemClick: (ArticleEntity) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentArticleListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        with(holder) {
            title.text = item.title
            author.text = item.byline
            date.text = item.publishedDate

            Glide.with(itemView)
                .load(item.media?.mediaMetadata?.first()?.url?.toUri())
                .placeholder(R.drawable.ic_baseline_image_24)
                .skipMemoryCache(true)
                .circleCrop()
                .into(icon)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentArticleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                itemClick(values[absoluteAdapterPosition])
            }
        }

        val title: TextView = binding.articleTitle
        val author: TextView = binding.articleAuthors
        val date: TextView = binding.articleDate
        val icon: ImageView = binding.itemIcon
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setArticles(items: List<ArticleEntity>?) {
        if (items != null) {
            values = items
        }
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(callback: (ArticleEntity) -> Unit) {
        itemClick = callback
    }

}