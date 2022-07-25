package com.example.cocktail.view.Favourites

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktail.Adapter.FavoriteAdapter
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.databinding.FragmentFavouritesBinding
import com.example.cocktail.listener.OnClickItemFavorite
import com.example.cocktail.model.Favorite
import com.example.cocktail.model.FavoriteDatabase
import com.example.cocktail.view.Details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouritesBinding? = null
    private val binding: FragmentFavouritesBinding get() = _binding!!

    val viewModel : FavoriteViewModel by viewModels()


    private val adapterFavorite: FavoriteAdapter by lazy {
        FavoriteAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouritesBinding.inflate(layoutInflater)

        setListFavorite()
        observeFavoriteList()

        viewModel.loadFovoriteData()

        return binding.root
    }

    private fun observeFavoriteList() {
        viewModel.favoriteEntityList.observe(viewLifecycleOwner, {
            adapterFavorite.setDataFavorite(it)
        })
    }

    private fun setListFavorite() {
        binding.rvFavourites .setHasFixedSize(true)
        binding.rvFavourites.adapter = adapterFavorite
        adapterFavorite.onClickItemFavorite = object : OnClickItemFavorite {
            override fun onClick(favorite: Favorite) {
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra("id", favorite.idDrink)
                startActivity(intent)
            }

            override  fun onClickFav(favorite: Favorite) {
                viewModel.removeDrink(favorite.idDrink)
                Toast.makeText(activity, "Drink removed from favorite", Toast.LENGTH_SHORT).show()
                observeFavoriteList()
            }
        }

    }

}