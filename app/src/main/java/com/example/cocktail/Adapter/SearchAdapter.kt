package com.example.cocktail.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cocktail.databinding.ListSearchBinding
import com.example.cocktail.model.Drink
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemSearch


class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var list: MutableList<Drink> = mutableListOf()
    var onClickItemSearch: OnClickItemSearch?= null

    inner class SearchViewHolder(private val binding: ListSearchBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(drink: Drink){

            binding.txtSearchTitle.text = drink.strDrink

            Glide.with(itemView)
                .load(drink.strDrinkThumb)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.ivSearch)

            itemView.setOnClickListener {
                onClickItemSearch?.onClick(drink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= SearchViewHolder(
    ListSearchBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataSearch(data: List<Drink>){
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}