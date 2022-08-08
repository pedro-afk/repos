package com.example.portifolio.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.portifolio.data.model.Repositories
import com.example.portifolio.databinding.ItemRepoBinding

class RepoListAdapter: ListAdapter<Repositories, RepoListAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRepoBinding
        ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Repositories) {
            binding.tvRepoName.text = item.name
            binding.tvRepoDescription.text = item.description
            binding.tvRepoLanguage.text = item.language
            binding.chipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context).load(item.owner.avatarURL).into(binding.ivOwner)
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<Repositories>() {
    override fun areItemsTheSame(oldItem: Repositories, newItem: Repositories) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repositories, newItem: Repositories) = oldItem.id == newItem.id
}
