package shubhamji.com.newspaper.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import shubhamji.com.newspaper.database.entity.Article
import shubhamji.com.newspaper.database.entity.News
@Dao
interface articleDao {
    @Insert
    fun insert(News: Article)
    @Update
    fun update(News: Article)
    @Query("select * from article order by id")
    fun getnews(): LiveData<List<Article>>
    @Query("select * from article order by id limit 1")
    fun getLatestnews(): Article?
    @Query("select * from article order by id desc")
    fun getLatest(): LiveData<List<Article>>
    @Query("delete from article")
    fun clear()
}