package com.puzzle.bench.post_aac.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.puzzle.bench.post_aac.FavoritePostFragment
import com.puzzle.bench.post_aac.AllPostFragment
import java.lang.IndexOutOfBoundsException

const val MAIN_POST_LIST = 0
const val MY_FAVORITE_POST = 1

class PostPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {


    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        MAIN_POST_LIST to { AllPostFragment() },
        MY_FAVORITE_POST to { FavoritePostFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {

        return tabFragmentsCreators[position]?.invoke() ?: throw  IndexOutOfBoundsException()
    }


}