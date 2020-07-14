package shubhamji.com.newspaper.domain

import shubhamji.com.newspaper.network.ressponse.Source

data class NewsArticle(
    val author: String,

    val content: String,

    val description: String,

    val publishedAt: String,

    val source: Source,

    val title: String,

    val url: String,

    val urlToImage: String
)