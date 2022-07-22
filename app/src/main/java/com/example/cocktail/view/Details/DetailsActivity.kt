package com.example.cocktail.view.Details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.cocktail.data.RepositoryImpl
import com.example.cocktail.databinding.ActivityDetailsBinding
import com.example.cocktail.model.Drink


class DetailsActivity : AppCompatActivity() {

    private val id: Int by lazy {
        intent.getIntExtra("id", 0)
    }

    private lateinit var binding: ActivityDetailsBinding

    private val viewModel: DetailsViewModle by lazy {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return DetailsViewModle(RepositoryImpl()) as T
            }
        }.create(DetailsViewModle::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationBack()
        observeDetailMovie()

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
        binding.txtTitle .text = drink.strDrink
        binding.txtIngredient1.text = drink.strIngredient1
        binding.txtIngredient2.text = drink.strIngredient2
        binding.txtIngredient3.text = drink.strIngredient3
        binding.txtIngredient4 .text =  drink.strIngredient4
    }

}


