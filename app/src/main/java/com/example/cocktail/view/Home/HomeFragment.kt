package com.example.cocktail.view.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktail.Adapter.ListAdapter
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.databinding.FragmentHomeBinding
import com.example.cocktail.listener.OnClickItemList
import com.example.cocktail.model.Drink
import com.example.cocktail.view.Details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val adapter: ListAdapter by lazy {
        ListAdapter()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    val viewModel :HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        observe()
        setList()


        viewModel.requestUpcoming()

        return binding.root
    }

    private fun observe() {
        viewModel.drinksResponseList.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun setList() {
        binding.rvDrinks.adapter = adapter
        adapter.onClickListener= object : OnClickItemList {
            override fun onClick(drink: Drink) {
                navigationToDetail(drink)
            }
        }
    }

    private fun navigationToDetail(drink: Drink){
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("id", drink.idDrink)
        startActivity(intent)
    }
}


