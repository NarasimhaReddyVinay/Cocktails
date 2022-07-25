package com.example.cocktail.view.Details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.databinding.ActivityDetailsBinding
import com.example.cocktail.model.Drink
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val id: Int by lazy {
        intent.getIntExtra("id", 0)
    }

    private lateinit var binding: ActivityDetailsBinding

    val viewModel : DetailsViewModle by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationBack()
        observeDetailMovie()
        observeIsFavorited()

        viewModel.requestDetailMovie(id)

    }

    private fun navigationBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun observeDetailMovie(){
        viewModel.detailsResponse.observe(this, {
            loadPoster(it)
            loadDetail(it)

            viewModel.checkFavMovie()
        })
    }

    private fun loadPoster(drink: Drink) {
        Glide.with(this)
            .load(drink.strDrinkThumb)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(binding.ivDrink)
    }

    private fun loadDetail(drink: Drink) {
        binding.apply {
            txtTitle .text = drink.strDrink
            txtIngredient1.text = drink.strIngredient1
            txtIngredient2.text = drink.strIngredient2
            txtIngredient3.text = drink.strIngredient3
            txtIngredient4 .text =  drink.strIngredient4
        }

    }

    private fun observeIsFavorited(){
        viewModel.isFavorited.observe(this,{
            binding.cbFavList.isChecked = it
            addFavoriteMovie()
        })
    }

    private fun addFavoriteMovie(){
        binding.cbFavList.setOnCheckedChangeListener { checkBox, isChecked ->
            if (isChecked){
                viewModel.saveDrink()
                Toast.makeText(this, "Drink added to favorite", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.removeDrink()
                Toast.makeText(this, "Drink removed from favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

}


