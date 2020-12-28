package shubhamji.com.newspaper.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import shubhamji.com.newspaper.database.entity.News

@Dao
interface databaseDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(News: News)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtcle(News: List<News>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(News: List<News>)
//    @Query("select * from news order by newsid")
//    fun getnews(): LiveData<List<News>>
    @Query("select * from news order by newsid limit 1")
    fun getLatestnews(): News?
    @Query("select * from news order by newsid desc")
    fun getNewsList(): LiveData<List<News>>
    @Query("delete from news")
    fun clear()
}