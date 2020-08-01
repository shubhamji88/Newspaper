package shubhamji.com.newspaper.startup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import shubhamji.com.newspaper.database.dao.databaseDAO
import shubhamji.com.newspaper.database.entity.News
import shubhamji.com.newspaper.database.stack.Stack.Companion.stack

class startupViewModel(
    val database: databaseDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob= Job()
    private var uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)
    val newNews=MutableLiveData<News?>()
    init{

        initalizeNewNews()
    }
    private fun initalizeNewNews()
    {
        uiScope.launch {
            newNews.value=getNewsFromDataBase()
        }
    }
    private suspend fun getNewsFromDataBase(): News?
    {
        return withContext(Dispatchers.IO){
            var News=database.getLatestnews()
            if(News?.title=="Nothing")
                News=null
            News
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun addnews(title: String,body: String)
    {
        uiScope.launch {
            val News= News()
            News.title=title
            News.description=body
            insert(News)
            newNews.value=News
            stack.add(News)
        }
    }
    private suspend fun insert(News: News)
    {
        withContext(Dispatchers.IO)
        {
            database.insert(News)
        }
    }
}