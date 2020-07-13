package shubhamji.com.newspaper.network.ressponse


import com.google.gson.annotations.SerializedName
import shubhamji.com.newspaper.database.Article

data class NewsList(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)