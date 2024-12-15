package com.example.newsapplicationxml.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.domain.model.Article
import com.example.newsapplicationxml.R
import com.example.newsapplicationxml.databinding.ActivityArticleDetailsBinding

class ArticleDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityArticleDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        window.apply {
//            decorView.systemUiVisibility =
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            statusBarColor = Color.TRANSPARENT
//        }

        val article: Article? = intent.getSerializableExtra("passedArticle") as? Article
         initView(article)
    }

    private fun initView(article: Article?) {
        binding.category.text=article?.source?.name
        binding.title.text=article?.title
        binding.state.text=article?.author
        binding.source.text=article?.source?.name
        binding.content.text=article?.content
        Glide.with(this)
            .load(article?.urlToImage)
            .into(binding.img)
        Glide.with(this)
            .load(article?.urlToImage)
            .into(binding.imgSource)
    }
}