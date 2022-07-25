package com.example.cocktail.view.Favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktail.data.Repository
import com.example.cocktail.model.Favorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _favoriteEntityList = MutableLiveData<ArrayList<Favorite>>()
    val favoriteEntityList: LiveData<ArrayList<Favorite>> = _favoriteEntityList

    private var dataFavorite: ArrayList<Favorite> = ArrayList()

    fun loadFovoriteData() {
         viewModelScope.launch {
             dataFavorite.clear()
             dataFavorite.addAll(repository.getAllDb())
             _favoriteEntityList.postValue(dataFavorite)
         }
    }

     fun removeDrink(id:Int) {
         viewModelScope.launch {
             repository.removeDrink(id)
             loadFovoriteData()
         }
    }

}
