package shubhamji.com.newspaper.investor

import android.app.Application
import androidx.lifecycle.*
import shubhamji.com.newspaper.database.databaseDAO

class investorViewModel(
    val database: databaseDAO,
    application: Application
): AndroidViewModel(application) {
    val heading=database.getLatest()
//    private var viewModelJob= Job()
//    private var uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)
    override fun onCleared() {
        super.onCleared()


    }
}