package com.example.newsapplicationxml.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.model.BreakingNews
import com.example.newsapplicationxml.R
import com.example.newsapplicationxml.databinding.ItembreakingnewsBinding

class BreakingNewsAdapter(var newslist:List<BreakingNews>?):RecyclerView.Adapter<BreakingNewsAdapter.BreakingNewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        val itembinding=ItembreakingnewsBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return BreakingNewsViewHolder(itembinding)
    }


    override fun getItemCount(): Int {
        return newslist?.size?:0
    }


    override fun onBindViewHolder(holder: BreakingNewsViewHolder, position: Int) {
        val newsItem = newslist?.get(position)
        if (newsItem != null) {
            holder.Bind(newsItem)
        }
    }




    fun changeData(articles: List<BreakingNews>?) {
        if (articles !=null){
            newslist = articles
            notifyDataSetChanged()


        }}

    class BreakingNewsViewHolder(val binding: ItembreakingnewsBinding) : ViewHolder(binding.root) {

        fun Bind(news: BreakingNews) {
if(news !=null){
            val newsTitle = news.source?.name?: ""
             binding.title.text = newsTitle.toString()
            val newsSource = news.source?.id ?: ""
            binding.source.text = newsSource.toString()

            val newsDescription = news.title ?: ""
            binding.description.text = newsDescription
         val newsdate = news.publishedAt ?: ""
             binding.date.text = newsdate.toString()
            Glide.with(itemView)
                .load( news.urlToImage)
                .into(binding.img)
        }}
    }



}




