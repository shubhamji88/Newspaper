package shubhamji.com.newspaper.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class News(
    @PrimaryKey(autoGenerate = true)
    var newsid: Long=0L,
    @ColumnInfo(name="Headline")
    var headline : String="Nothing",
    @ColumnInfo(name = "body")
    var body: String="Body")