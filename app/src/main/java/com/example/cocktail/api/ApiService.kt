package com.example.cocktail.api

import com.example.cocktail.model.Drink
import com.example.cocktail.model.Drinks
import com.example.cocktail.util.Constant
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{


    @GET("search.php?s=")
    suspend fun getDrinkQuery(
        @Query("query") query: String,
    ): Response<Drinks>

    @GET("search.php?s=margarita")
    suspend fun getDrinks(
    ): Response<Drinks>

    @GET("lookup.php?i=")
    suspend fun getDetails(
        @Query("id") id: Int,
    ): Response<Drink>


    companion object {
        private var instance: ApiService? = null
        fun getApiService(): ApiService{
            if (instance == null){
                instance = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return instance!!
        }
    }
}