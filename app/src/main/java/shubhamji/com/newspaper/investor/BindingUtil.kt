package shubhamji.com.newspaper.investor

import android.widget.TextView
import androidx.databinding.BindingAdapter
import shubhamji.com.newspaper.database.News

@BindingAdapter("headline")
fun TextView.head(item: News)
{
    text=item.headline
}

@BindingAdapter("body")
fun TextView.body(item: News)
{
    text=item.body
}