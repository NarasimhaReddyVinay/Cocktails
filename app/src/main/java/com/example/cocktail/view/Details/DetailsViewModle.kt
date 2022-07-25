package com.example.cocktail.view.Details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktail.data.Repository
import com.example.cocktail.model.Drink
import com.example.cocktail.model.Favorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModle @Inject constructor( val repository:Repository ) : ViewModel() {

    private val _detailsResponse = MutableLiveData<Drink>()
    val detailsResponse: LiveData<Drink> = _detailsResponse

    private val _isfavorited = MutableLiveData<Boolean>()
    val isFavorited: LiveData<Boolean> = _isfavorited


    fun requestDetailMovie(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getDetails(id)
            _detailsResponse.postValue(response.copy())
        }
    }

    fun saveDrink() {
        viewModelScope.launch {
            val drink = _detailsResponse.value!!
            val favorite = Favorite(
                idDrink = drink.idDrink
            )
            repository.saveDrink(favorite)
        }
    }

    fun removeDrink() {
        viewModelScope.launch {
            val drink = _detailsResponse.value!!
            repository.removeDrink(drink.idDrink)
        }
    }

    fun checkFavMovie() {
        viewModelScope.launch {
            val detail = _detailsResponse.value!!
            _isfavorited.postValue(repository.checkDrink(detail.idDrink))
        }
    }

}






