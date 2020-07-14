package shubhamji.com.newspaper.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import shubhamji.com.newspaper.domain.NewsArticle
import shubhamji.com.newspaper.network.ressponse.Source
@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L,

    val author: String,

    val content: String,

    val description: String,

    val publishedAt: String,
    @Embedded(prefix = "source_")
    val source: Source,

    val title: String,

    val url: String,

    val urlToImage: String
)
fun List<Article>.toNewsArticle():List<NewsArticle>{
    return map{
        NewsArticle(
            author = it.author,
            content = it.content,
            description = it.description,
            publishedAt = it.publishedAt,
            source = it.source,
            title = it.title,
            url=it.url,
            urlToImage = it.urlToImage
        )
    }
}