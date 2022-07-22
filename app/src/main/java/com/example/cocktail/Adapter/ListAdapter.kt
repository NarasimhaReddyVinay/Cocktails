package com.example.cocktail.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cocktail.databinding.ListBinding
import com.example.cocktail.listener.OnClickItemList
import com.example.cocktail.model.Drink

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var list: MutableList<Drink> = mutableListOf()
    var onClickListener: OnClickItemList? =null

    inner class ListViewHolder(private val binding: ListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(drink: Drink){


            binding.txtTitleFavorite.text = drink.strDrink

            Glide.with(itemView)
                .load(drink.strDrinkThumb)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivDetailFav)


            itemView.setOnClickListener {
                onClickListener?.onClick(drink)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ListViewHolder(
        ListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return if (list.size >= 8){
            8
        }else{
            list.size
        }
    }

    fun setDataUpcoming(data: List<Drink>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}