package com.example.cocktail.view.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktail.data.Repository
import com.example.cocktail.model.Drink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: Repository): ViewModel() {

    private val _drinksResponseList = MutableLiveData<List<Drink>>()
    val drinksResponseList: LiveData<List<Drink>> = _drinksResponseList

    fun requestUpcoming(){
        CoroutineScope(Dispatchers.Main).launch{
            val response = repository.getDrinks()
            _drinksResponseList.postValue(response.drinks)
        }
    }


}

