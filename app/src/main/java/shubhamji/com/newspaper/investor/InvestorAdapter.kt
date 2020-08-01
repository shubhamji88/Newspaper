package shubhamji.com.newspaper.investor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.database.entity.News
import shubhamji.com.newspaper.databinding.ListBinding

private val ITEM_VIEW_TYPE_ITEM = 1
class InvestorAdapter(val clickListnerimg: ClickListnerImage): ListAdapter<News, RecyclerView.ViewHolder>(NewsDiffCallBack()) {

    @SuppressLint("DiffUtilEquals")
    class NewsDiffCallBack : DiffUtil.ItemCallback<News>()
    {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.newsid==newItem.newsid
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem==newItem
        }


    }
    class HeaderViewHolder(view: View):RecyclerView.ViewHolder(view){
        companion object{
            fun from(parent: ViewGroup):HeaderViewHolder{
                val layoutInflater=LayoutInflater.from(parent.context)
                val view=layoutInflater.inflate(R.layout.header,parent,false)
                return HeaderViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return ITEM_VIEW_TYPE_ITEM
    }
    class ViewHolder private constructor(val binding: ListBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = ListBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(view)
            }
        }
        fun bind(item: News, clickListnerimg: ClickListnerImage) {
            binding.imageClick=clickListnerimg
            binding.newss=item

            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder->{
                val item=getItem(position) as News
                holder.bind(item,clickListnerimg)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

}
class ClickListnerImage(val clisklistner: (Long)-> Unit){
    fun onClicknumber(news: News)= clisklistner(news.newsid)
}
//sealed class DataItem{
//    abstract val id: Long
//    object Header: DataItem()
//    {
//        override val id=Long.MIN_VALUE
//    }
//    data class newsItem (val news: News):News(){
//        override val id =news.newsid
//    }
//}
