package com.example.cocktail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.cocktail.R
import com.example.cocktail.databinding.ActivityMainBinding
import com.example.cocktail.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.ViewPager
        viewPager.adapter = viewPagerAdapter
        val tabs: TabLayout = binding.tabLayout
        tabs.setupWithViewPager(viewPager)


        tabs.getTabAt(0)?.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)?.setIcon(R.drawable.ic_baseline_search_24)
        tabs.getTabAt(2)?.setIcon(R.drawable.ic_baseline_favorite_24)
    }
}