package com.example.cocktail.listener

import com.example.cocktail.model.Drink


interface OnClickItemList {
    fun onClick (drink: Drink)
}