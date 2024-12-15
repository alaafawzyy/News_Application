package com.example.newsapplicationxml.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.model.Article
import com.example.newsapplicationxml.databinding.ItemnewsBinding


class NewsAdapter(var newslist:List<Article?>?):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itembinding= ItemnewsBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return NewsViewHolder(itembinding)
    }


    override fun getItemCount(): Int {
        Log.d("NewsAdapter", "getItemCount: ${newslist?.size}")
        return newslist?.size ?: 0
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = newslist?.get(position)
        if (newsItem != null) {
            holder.Bind(newsItem)
            holder.binding.root.setOnClickListener{onArticleListener?.OnArticlelClick(newsItem)}
        }
    }



    fun changeData(articles: List<Article?>?) {
        if (articles !=null){
            newslist = articles
            notifyDataSetChanged()


        }}


    class NewsViewHolder(val binding:ItemnewsBinding ) : ViewHolder(binding.root) {
        fun Bind(news: Article?) {
            binding.author.text=news?.author ?:"No author"
            binding.title.text = news?.title ?: "No title"
            binding.date.text = news?.publishedAt ?: "No date"
            Glide.with(itemView)
                .load(news?.urlToImage)
                .into(binding.img)
        }
    }

    private var onArticleListener: OnArticlelClickistener?=null
    fun setOnArticleListener(listener: OnArticlelClickistener){
        onArticleListener=listener

    }
    fun interface OnArticlelClickistener{
        fun OnArticlelClick(article: Article)
    }
}




