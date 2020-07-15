package shubhamji.com.newspaper.network
//
//import shubhamji.com.newspaper.database.entity.News
//
//data class NewsListTemp(
//val status: String?=null,
//val totalResults :Int?=null,
//val articles: List<NewsData>
//) {
//}
//data class NewsData(
//    val source: List<source>,
//    val author:String,
//    val title:String,
//    val description:String,
//    val url:String,
//    val urlToImage:String,
//    val publishedAt:String,
//    val content:String
//)
//data class source(
//    val id : String,
//    val name: String
//)
//fun List<NewsListTemp>.toArticleDatabase():List<News>{
//    return map {
//        News(
//            author = it.articles[0].author,
//            content = it.articles[0].content,
//            description = it.articles[0].description,
//            publishedAt = it.articles[0].publishedAt,
////            source = it.articles[0].source,
//            title = it.articles[0].title,
//            urlToImage = it.articles[0].urlToImage,
//            url = it.articles[0].url
//
//        )
//    }
//}