package com.example.cocktail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idDrink")
    val idDrink: Int,
    @ColumnInfo(name = "serDrinkThumb")
    val strDrinkThumb: String? = "",
    @ColumnInfo(name = "strDrink")
    val strDrink: String? = "",
)
