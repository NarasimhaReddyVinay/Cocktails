package com.example.cocktail

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cocktail.view.FavouritesFragment
import com.example.cocktail.view.Home.HomeFragment
import com.example.cocktail.view.search.SearchFragment


class ViewPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> HomeFragment()
            1 -> SearchFragment()
            2 -> FavouritesFragment()
            else -> {
                HomeFragment()
            }
        }
    }
}