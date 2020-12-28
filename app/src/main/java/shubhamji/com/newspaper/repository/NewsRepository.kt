package shubhamji.com.newspaper.repository



import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.network.NewsApi
import shubhamji.com.newspaper.network.Response.NewsList
import shubhamji.com.newspaper.network.Response.toArticleDatabase

lateinit var news:NewsList
class NewsRepository(private val database: NewsDatabase) {

    suspend fun refreshNews(){
        withContext(Dispatchers.IO){
            news=NewsApi.retrifitService.getNews().await()
            database.newsdatabaseDAO.insertArtcle(news.toArticleDatabase())
        }

    }
}