package shubhamji.com.newspaper.network.ressponse


import com.google.gson.annotations.SerializedName
import shubhamji.com.newspaper.database.entity.News

data class NewsList(
    @SerializedName("articles")
    val articles: List<ArticleResponse>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)
fun List<NewsList>.toArticleDatabase():List<News>{
    return map {
        News(
            author = it.articles[0].author,
            content = it.articles[0].content,
            description = it.articles[0].description,
            publishedAt = it.articles[0].publishedAt,
//            source = it.articles[0].source,
            title = it.articles[0].title,
            urlToImage = it.articles[0].urlToImage,
            url = it.articles[0].url

        )
    }
}