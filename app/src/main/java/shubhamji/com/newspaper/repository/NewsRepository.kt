package shubhamji.com.newspaper.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.network.NewsApi
import shubhamji.com.newspaper.network.ressponse.toArticleDatabase
import timber.log.Timber

class NewsRepository(private val database: NewsDatabase) {
    suspend fun refreshNews(){
        withContext(Dispatchers.IO){
            val news=NewsApi.retrifitService.getNews().await()
            Timber.i(" kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\nkkkkkkkkkkkkkkkkkkkkkk")
            database.articledao.insert(news.toArticleDatabase())
        }
    }
}