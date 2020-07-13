package shubhamji.com.newspaper.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import shubhamji.com.newspaper.database.entity.News

@Dao
interface databaseDAO {
    @Insert
    fun insert(News: News)
    @Update
    fun update(News: News)
    @Query("select * from news order by newsid")
    fun getnews(): LiveData<List<News>>
    @Query("select * from news order by newsid limit 1")
    fun getLatestnews(): News?
    @Query("select * from news order by newsid desc")
    fun getLatest(): LiveData<List<News>>
    @Query("delete from news")
    fun clear()
}