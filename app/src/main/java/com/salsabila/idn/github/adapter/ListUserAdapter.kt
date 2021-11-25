package com.salsabila.idn.github.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.salsabila.idn.github.Detail
import com.salsabila.idn.github.databinding.ItemUserBinding
import com.salsabila.idn.github.model.User
import org.jetbrains.anko.intentFor

class ListUserAdapter (private val ListUser : ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>(){
    inner class ListViewHolder (var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            with(binding){
                //menampilkan item nya
                Glide.with(binding.ivProfile.context)
                    .load(user.photo)
                    .apply(RequestOptions().override(60,60))
                    .into(binding.ivProfile)

                binding.tvName.text = user.name
                binding.tvUserName.text = user.username

                itemView.setOnClickListener{
                    itemView.context.startActivity(
                        itemView.context.intentFor<Detail>(
                            "extra_username" to user
                        )
                    )
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(ListUser[position])
    }

    override fun getItemCount(): Int  = ListUser.size
}