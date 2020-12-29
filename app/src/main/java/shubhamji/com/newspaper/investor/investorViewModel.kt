package shubhamji.com.newspaper.investor

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.*
import shubhamji.com.newspaper.database.dao.databaseDAO
import shubhamji.com.newspaper.database.entity.News

class investorViewModel(
    val databaseDAO: databaseDAO,
    application: Application
): AndroidViewModel(application) {
    val newsList=databaseDAO.getNewsList()
}