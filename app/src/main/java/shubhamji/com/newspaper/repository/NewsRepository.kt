package shubhamji.com.newspaper.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.database.stack.Stack
import shubhamji.com.newspaper.network.Response.NewsList

import shubhamji.com.newspaper.network.NewsApi
import shubhamji.com.newspaper.network.Response.toArticleDatabase
//import shubhamji.com.newspaper.network.Response.toArticleDatabase

import timber.log.Timber
lateinit var news:NewsList
class NewsRepository(private val database: NewsDatabase) {
    val stack=Stack
    suspend fun refreshNews(){
        withContext(Dispatchers.IO){
            news=NewsApi.retrifitService.getNews().await()
//            database.newsdatabaseDAO.insertArtcle(news.toArticleDatabase())
            stack.pushAll(news.toArticleDatabase())
//            stack.display()
        }

    }
}