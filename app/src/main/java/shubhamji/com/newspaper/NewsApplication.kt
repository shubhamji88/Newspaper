package shubhamji.com.newspaper

import android.app.Application
import timber.log.Timber

class NewsApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}