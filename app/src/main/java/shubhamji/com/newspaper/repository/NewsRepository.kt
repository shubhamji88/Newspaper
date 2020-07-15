package shubhamji.com.newspaper.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.database.entity.News
import shubhamji.com.newspaper.network.NewsApi
import shubhamji.com.newspaper.network.ressponse.NewsList
import shubhamji.com.newspaper.network.ressponse.toArticleDatabase
import timber.log.Timber
lateinit var news:List<NewsList>
class NewsRepository(private val database: NewsDatabase) {
    suspend fun refreshNews(){
        Timber.i("Starting\nthe\ninternet\nconnection")
        withContext(Dispatchers.IO){
            Timber.i("Start\nthe\ninternet\nconnection")
            Timber.i("Start\nthe\ninternet\nconnection")
            news=NewsApi.retrifitService.getNews().await()
            database.newsdatabaseDAO.insertArtcle(news.toArticleDatabase())

        }

    }
}