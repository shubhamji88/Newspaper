package shubhamji.com.newspaper.investor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import shubhamji.com.newspaper.database.entity.News
import shubhamji.com.newspaper.databinding.ListBinding

private val ITEM_VIEW_TYPE_ITEM = 1
class InvestorAdapter(val clickListner: ClickListner): ListAdapter<News, RecyclerView.ViewHolder>(NewsDiffCallBack()) {

    class NewsDiffCallBack : DiffUtil.ItemCallback<News>()
    {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.newsid==newItem.newsid
        }
        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem==newItem
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
        fun bind(item: News, clickListnerimg: ClickListner) {
            binding.click=clickListnerimg
            binding.newss=item

            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder->{
                val item=getItem(position)
                holder.bind(item,clickListner)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

}
class ClickListner(val clisklistner: (String)-> Unit){
    fun onClickurl(url :String)= clisklistner(url)
}

