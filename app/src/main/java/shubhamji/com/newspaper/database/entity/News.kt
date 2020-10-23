package shubhamji.com.newspaper.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "News")
data class News(
    @PrimaryKey(autoGenerate = true)
    var newsid: Long=0L,

    var title : String?="Nothing",

    var description: String?="Body",

    var author: String?="author",

    val content: String?="con",

    var publishedAt: String?="publishedAt",
//    @Embedded(prefix = "source_")
//    val source: Source?=null,

    var url: String?="url",

    val urlToImage: String?="urltoimage"
)