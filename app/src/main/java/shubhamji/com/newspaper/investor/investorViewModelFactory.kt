package shubhamji.com.newspaper.investor

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import shubhamji.com.newspaper.database.dao.databaseDAO

class investorViewModelFactory(
    private val dataSource: databaseDAO,
    private val application: Application
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(investorViewModel::class.java)) {
            return investorViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}