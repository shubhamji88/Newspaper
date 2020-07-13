package shubhamji.com.newspaper.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import shubhamji.com.newspaper.database.dao.databaseDAO

@Database(entities = [News::class],version = 1,exportSchema = false)
abstract class NewsDatabase : RoomDatabase()
{
    abstract val newsdatabaseDAO: databaseDAO
//    abstract val internetdao: internetdao

    companion object{
        @Volatile
        private var INSTANCE : NewsDatabase?=null
        fun getInstance(context: Context):NewsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}