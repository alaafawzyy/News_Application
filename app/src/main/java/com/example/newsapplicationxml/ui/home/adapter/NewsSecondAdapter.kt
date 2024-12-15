package com.example.newsapplicationxml.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.model.Article
import com.example.domain.model.BreakingNews
import com.example.newsapplicationxml.databinding.ItemnewsBinding
import com.example.newsapplicationxml.databinding.ItemnewsSecondBinding


class NewsSecondAdapter(var newslist:List<BreakingNews?>?):RecyclerView.Adapter<NewsSecondAdapter.NewsSecondViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSecondViewHolder {
        val itembinding= ItemnewsSecondBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return NewsSecondViewHolder(itembinding)
    }


    override fun getItemCount(): Int {
        return newslist?.size ?: 0
    }


    override fun onBindViewHolder(holder: NewsSecondViewHolder, position: Int) {
        val newsItem = newslist?.get(position)
        if (newsItem != null) {
            holder.Bind(newsItem) }
    }



    fun changeData(articles: List<BreakingNews?>?) {
        if (articles !=null){
            newslist = articles
            notifyDataSetChanged()


        }}


    class NewsSecondViewHolder(val binding:ItemnewsSecondBinding ) : ViewHolder(binding.root) {
        fun Bind(news: BreakingNews?) {
            binding.category.text=news?.source?.name ?:"No category"
            binding.author.text=news?.author ?:"No author"
            binding.title.text = news?.title ?: "No title"
            binding.date.text = news?.publishedAt ?: "No date"
            Glide.with(itemView)
                .load(news?.urlToImage)
                .into(binding.imgAuthor)
            Glide.with(itemView)
                .load(news?.urlToImage)
                .into(binding.img)
        }
    }


}




