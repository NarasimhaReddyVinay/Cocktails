package com.example.cocktail.model


import com.google.gson.annotations.SerializedName

data class Drinks(
    @SerializedName("drinks")
    val drinks: List<Drink> = listOf()
)