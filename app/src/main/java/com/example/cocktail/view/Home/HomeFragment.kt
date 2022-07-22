package com.example.cocktail.view.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktail.Adapter.ListAdapter
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.databinding.FragmentHomeBinding
import com.example.cocktail.listener.OnClickItemList
import com.example.cocktail.model.Drink
import com.example.cocktail.view.Details.DetailsActivity


class HomeFragment : Fragment() {

    private val adapter: ListAdapter by lazy {
        ListAdapter()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!


    private val viewModel: HomeViewModel by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(RepositoryImpl()) as T
            }
        }.create(HomeViewModel::class.java)
    }

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
            adapter.setDataUpcoming(it)
        }
    }

    private fun setList() {
        binding.rvDrinks.adapter = adapter
        adapter.onClickListener= object : OnClickItemList {
            override fun onClick(drink: Drink) {
                navigationToDetailUpcoming(drink)
            }
        }
    }

    private fun navigationToDetailUpcoming(drink: Drink){
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("id", drink.idDrink)
        startActivity(intent)
    }
}


