package com.example.cocktail.data

import com.example.cocktail.api.ApiService
import com.example.cocktail.model.*
import javax.inject.Inject


interface Repository{
    suspend fun getDrinkQuery(query: String?): Drinks

    suspend fun getDrinks(): Drinks

    suspend fun getDetails(id: Int): Drink

     suspend fun saveDrink(favorite: Favorite)

     suspend fun removeDrink(id: Int)

     suspend fun checkDrink(id: Int): Boolean

     suspend fun getAllDb(): ArrayList<Favorite>
}

class RepositoryImpl @Inject constructor (private val Service: ApiService ,private val favoriteDatabase: FavoriteDao) : Repository
{
    override suspend fun getDrinkQuery(query: String?): Drinks {
        val response=Service.getDrinkQuery(query = query.toString())
        return if(response.isSuccessful){
            response.body()!!
        }else{
            Drinks()
        }
    }


    override suspend fun getDrinks(): Drinks {
        val response=Service.getDrinks()
        return if (response.isSuccessful){
            response.body()!!
        }else{
            Drinks(emptyList())
        }
    }

    override suspend fun getDetails(id: Int): Drink {
        val response=Service.getDetails(id = id)
        return if(response.isSuccessful){
            response.body()!!
        }else{
            Drink(id)
        }
    }

    override suspend fun saveDrink(favorite: Favorite) {
        favoriteDatabase.insert(favorite)
    }

    override suspend fun removeDrink(id: Int) {
        favoriteDatabase.deleteById(id)
    }

    override suspend fun checkDrink(id: Int): Boolean {
        val isFavorited = favoriteDatabase.getById(id).isNotEmpty()
        return isFavorited
    }

    override suspend fun getAllDb(): ArrayList<Favorite> {
        val dataFromBd = favoriteDatabase.getAll()
        return dataFromBd as ArrayList<Favorite>
    }


}


