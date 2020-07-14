package shubhamji.com.newspaper.investor

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.database.dao.databaseDAO
import shubhamji.com.newspaper.network.NewsApi
import shubhamji.com.newspaper.network.ressponse.NewsList
import shubhamji.com.newspaper.repository.NewsRepository
import java.lang.Exception

class investorViewModel(
    val databaseDAO: databaseDAO,
    application: Application
): AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )
    private val database=NewsDatabase.getInstance(application)
    private val newsRepository=NewsRepository(database)

    init{
        getNewsFromInternet()

    }
    val heading=databaseDAO.getLatest()
    private val _news=MutableLiveData<List<NewsList>>()
    private val news:LiveData<List<NewsList>>?
                get() = _news
    fun getNewsFromInternet(){
        coroutineScope.launch {
            val getPropertiesDeferred=NewsApi.retrifitService.getNews()
            try{
//                val listResult=getPropertiesDeferred.await()
//                _news.value=listResult
                newsRepository.refreshNews()
            } catch (e :Exception){
                _news.value=ArrayList()
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()

    }
}