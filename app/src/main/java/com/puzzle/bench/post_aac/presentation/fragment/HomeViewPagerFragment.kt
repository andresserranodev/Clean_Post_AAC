package com.puzzle.bench.post_aac.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.presentation.adapter.MAIN_POST_LIST
import com.puzzle.bench.post_aac.presentation.adapter.MY_FAVORITE_POST
import com.puzzle.bench.post_aac.presentation.adapter.PostPagerAdapter
import com.puzzle.bench.post_aac.databinding.ViewPagerFragmentBinding

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ViewPagerFragmentBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = PostPagerAdapter(this)

        // Set the icon and text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }


    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MAIN_POST_LIST -> getString(R.string.tap_title_all_post)
            MY_FAVORITE_POST -> getString(R.string.tap_title_favorite)
            else -> null
        }
    }
}