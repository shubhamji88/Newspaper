package shubhamji.com.newspaper.investor

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*
import shubhamji.com.newspaper.database.dao.databaseDAO

class investorViewModel(
    val databaseDAO: databaseDAO,
    application: Application
): AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.IO )
//    private val database=NewsDatabase.getInstance(application)
//    private val newsRepository= NewsRepository(database)

    init{
//        getNewsFromDatabase()

    }
//    private val _heading=MutableLiveData<List<News>>()
//    private val heading:LiveData<List<News>>
//        get() = _heading
//    fun ger
    val newsList=databaseDAO.getNewsList()

//    fun getNewsFromInternet(){
//        coroutineScope.launch {
//            try{
//
//                    newsRepository.refreshNews()
//                Timber.i("Bending\nthe\ninternet\nconnection solveddddddddddddddddddddddddddd")
//
//            } catch (e :Exception){
//                _news.value=ArrayList()
//                Timber.i("Bending\nthe\ninternet\nconnection ${e}")
//            }
//        }
//    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()

    }

}