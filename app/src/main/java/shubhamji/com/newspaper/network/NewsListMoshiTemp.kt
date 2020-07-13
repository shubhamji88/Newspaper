package shubhamji.com.newspaper.network

data class NewsListTemp(
val status: String?=null,
val totalResults :Int?=null,
val articles: List<NewsData>?=null
) {
}
data class NewsData(
    val source: List<source>,
    val author:String?=null,
    val title:String?=null,
    val description:String?=null,
    val url:String?=null,
    val urlToImage:String?=null,
    val publishedAt:String?=null,
    val content:String?=null
)
data class source(
    val id : String?=null,
    val name: String?=null
)