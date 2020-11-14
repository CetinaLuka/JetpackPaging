package com.i.jetpackpaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.i.paging.models.Repository
import kotlinx.android.synthetic.main.repo_item.view.*

class RecyclerViewAdapter : PagedListAdapter<Repository, CustomViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.repo_item, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val repository: Repository? = getItem(position)
        holder.bind(repository)
    }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Repository, newItem: Repository) = oldItem == newItem
        }
    }
}
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(repo: Repository?){
        if(repo != null) {
            view.repo_name?.text = repo.fullName
            view.repo_description?.text = repo.description
            view.repo_stars?.text = repo.stars.toString()
        }
        else{
            view.repo_name?.text = "Podatki se nalagajo"
            view.repo_description?.text = ""
            view.repo_stars?.text = "0"
        }
    }
}