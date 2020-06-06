package shubhamji.com.newspaper.investor

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import shubhamji.com.newspaper.database.News
import shubhamji.com.newspaper.databinding.ListBinding

class investorAdapter: ListAdapter<News, investorAdapter.ViewHolder>(NewsDiffCallBack()) {


    class NewsDiffCallBack : DiffUtil.ItemCallback<News>()
    {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.newsid==newItem.newsid
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem==newItem
        }

    }
    class ViewHolder private constructor(val binding: ListBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = ListBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(view)
            }
        }

        fun bind(item: News) {
            binding.newss=item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


}