package com.example.cocktail.data

import com.example.cocktail.api.ApiService
import com.example.cocktail.model.Drink
import com.example.cocktail.model.Drinks

interface Repository{
    suspend fun getDrinkQuery(query: String?): Drinks

    suspend fun getDrinks(): Drinks

    suspend fun getDetails(id: Int): Drink
}

class RepositoryImpl(private val Service: ApiService = ApiService.getApiService()): Repository
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
        val response=Service.getDetails(id = id.toInt())
        return if(response.isSuccessful){
            response.body()!!
        }else{
            Drink()
        }
    }


}


