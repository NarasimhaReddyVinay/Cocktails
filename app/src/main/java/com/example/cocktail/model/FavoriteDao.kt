package com.example.cocktail.model

import androidx.room.*

@Dao
interface FavoriteDao {

    @Query("SELECT * From favorite")
    suspend fun getAll():List<Favorite>

    @Insert
    suspend fun insert(favoriteEntity: Favorite)

    @Delete
    suspend fun delete(favoriteEntity: Favorite)

    @Query("DELETE FROM favorite WHERE idDrink = :id")
    suspend fun deleteById(id: Int)

    @Update
    suspend fun update(favoriteEntity: Favorite)

    @Query("SELECT * From favorite Where idDrink = :id")
    suspend fun getById(id:Int):List<Favorite>
}
