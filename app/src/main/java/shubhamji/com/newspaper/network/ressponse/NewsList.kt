package shubhamji.com.newspaper.database


import com.google.gson.annotations.SerializedName
import shubhamji.com.newspaper.network.ressponse.Article

data class NewsList(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)