package shubhamji.com.newspaper.startup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*
import shubhamji.com.newspaper.database.dao.databaseDAO
import shubhamji.com.newspaper.database.entity.News


class startupViewModel(
    val database: databaseDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private suspend fun insert(News: News) {
        withContext(Dispatchers.IO)
        {
            database.insert(News)
        }
    }
    fun addnews(title: String, body: String, author: String, date: String, web: String) {
        uiScope.launch {
            val News = News()
            News.title = title
            News.description = body
            News.author = author
            News.publishedAt = date
            News.url = web
            insert(News)
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }



}