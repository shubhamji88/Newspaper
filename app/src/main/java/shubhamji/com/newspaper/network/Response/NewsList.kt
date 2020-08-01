package shubhamji.com.newspaper.network.Response


import androidx.lifecycle.Transformations.map
import com.google.gson.annotations.SerializedName
import shubhamji.com.newspaper.database.entity.News

data class NewsList(
    @SerializedName("articles")
    val articles: List<Article?>,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)
fun NewsList.toArticleDatabase():List<News>{
    return articles.map{
        News(
            author = it?.author,
            content = it?.content,
            description = it?.description,
            publishedAt = it?.publishedAt,
//            source = it.articles[0].source,
            title = it?.title,
            urlToImage = it?.urlToImage,
            url = it?.url
        )
    }

}