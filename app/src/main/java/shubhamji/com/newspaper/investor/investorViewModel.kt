package shubhamji.com.newspaper.investor

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*
import shubhamji.com.newspaper.database.dao.databaseDAO
import shubhamji.com.newspaper.network.NewsApi
import shubhamji.com.newspaper.network.ressponse.NewsList
import java.lang.Exception

class investorViewModel(
    val database: databaseDAO,
    application: Application
): AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )
    init{
        getNewsFromInternet()
    }
    val heading=database.getLatest()
    private val _news=MutableLiveData<List<NewsList>>()
    private val news:LiveData<List<NewsList>>?
                get() = _news
    fun getNewsFromInternet(){
        coroutineScope.launch {
            val getPropertiesDeferred=NewsApi.retrifitService.getNews()
            try{
                val listResult=getPropertiesDeferred.await()
                _news.value=listResult

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