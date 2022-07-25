package com.example.cocktail.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cocktail.databinding.ListBinding
import com.example.cocktail.listener.OnClickItemFavorite
import com.example.cocktail.model.Favorite

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var list: MutableList<Favorite> = mutableListOf()
    var onClickItemFavorite: OnClickItemFavorite? = null

    inner class FavoriteViewHolder(private val binding: ListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favorite: Favorite) {

            itemView.setOnClickListener {
                onClickItemFavorite?.onClick(favorite)
            }


            Glide.with(itemView)
                .load(favorite.strDrinkThumb)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivDetailFav)

            binding.txtTitleFavorite.text = favorite.strDrink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= FavoriteViewHolder (
        ListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
            )

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataFavorite(data: List<Favorite>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }


}