package com.example.cocktail.listener

import com.example.cocktail.model.Favorite


interface OnClickItemFavorite {
    fun onClick(favorite: Favorite)
    fun onClickFav(favorite: Favorite)
}