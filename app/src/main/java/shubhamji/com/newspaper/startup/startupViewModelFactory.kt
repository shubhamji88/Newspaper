package shubhamji.com.newspaper.startup

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import shubhamji.com.newspaper.database.dao.databaseDAO

class startupViewModelFactory(
    private val dataSource: databaseDAO,
    private val application: Application
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(startupViewModel::class.java)) {
            return startupViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}