package com.example.cocktail.view.search

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
class SearchViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    private val _searchResponse = MutableLiveData<List<Drink>>()
    val searchResponse: LiveData<List<Drink>> = _searchResponse


    fun requestDrinkQuery(query:String?) {
        CoroutineScope(Dispatchers.Main).launch{
            val response = repository.getDrinkQuery(query)
            _searchResponse.postValue(response.drinks)
        }
    }

}





