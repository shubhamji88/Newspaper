package shubhamji.com.newspaper.investor

import android.widget.TextView
import androidx.databinding.BindingAdapter
import shubhamji.com.newspaper.database.entity.News

@BindingAdapter("headline")
fun TextView.head(item: News)
{
    text=item.title
}

@BindingAdapter("body")
fun TextView.body(item: News)
{
    text=item.description
}
@BindingAdapter("author")
fun TextView.author(item: News)
{
    text=item.author
}
@BindingAdapter("publishedAt")
fun TextView.publishedAt(item: News)
{
    val t=item.publishedAt
    text=t?.subSequence(0,10)
}
