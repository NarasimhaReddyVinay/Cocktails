package com.example.cocktail.view.Details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktail.data.Repository
import com.example.cocktail.model.Drink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailsViewModle( val repository: Repository) : ViewModel() {

    private val _detailsResponse = MutableLiveData<Drink>()
    val detailsResponse: LiveData<Drink> = _detailsResponse



    fun requestDetailMovie(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getDetails(id)
            _detailsResponse.postValue(response.copy())
        }
    }

}






