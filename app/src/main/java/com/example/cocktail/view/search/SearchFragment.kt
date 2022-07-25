package com.example.cocktail.view.search

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktail.Adapter.SearchAdapter
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.databinding.FragmentSearchBinding
import com.example.cocktail.model.Drink
import com.example.cocktail.view.Details.DetailsActivity
import com.example.narasimhakonapalli_finalassignment.listener.OnClickItemSearch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!


    val viewModel : SearchViewModel by viewModels()


    private val adapterSearch: SearchAdapter by lazy {
        SearchAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentSearchBinding.inflate(layoutInflater)

        searchMovie()
        setListSearch()
        observeSearch()

        return binding.root

    }

    private fun searchMovie() {
        binding.searchMovie.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean{
                binding.searchMovie.clearFocus()
                viewModel.requestDrinkQuery(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun observeSearch(){
        viewModel.searchResponse.observe(viewLifecycleOwner) {
            adapterSearch.setDataSearch(it)
        }
    }

    private fun setListSearch(){
        binding.apply {
           rvMovieSearch.layoutManager=LinearLayoutManager(requireContext())
           rvMovieSearch.setHasFixedSize(true)
           rvMovieSearch.adapter = adapterSearch
            adapterSearch.onClickItemSearch = object : OnClickItemSearch {
            override fun onClick(drink: Drink){
                navigationToDetails(drink)
            }
        }
        }
    }

    private fun navigationToDetails(drink: Drink) {
        val intent = Intent(activity,DetailsActivity::class.java)
        intent.putExtra("id", drink.idDrink)
        startActivity(intent)
    }


}











