package com.puzzle.bench.post_aac.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.presentation.adapter.FavoritePostAdapter
import com.puzzle.bench.post_aac.presentation.di.ViewModelInjector
import com.puzzle.bench.post_aac.presentation.viewmodels.FavoritePostViewModel
import kotlinx.android.synthetic.main.favorite_post_fragment.*


class FavoritePostFragment : Fragment() {


    private val viewModel: FavoritePostViewModel by viewModels {
        ViewModelInjector.provideFavoritePostViewModel(requireContext())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val allPostAdapter = FavoritePostAdapter()
        favorite_post_rv.apply {
            adapter = allPostAdapter
            addItemDecoration(DividerItemDecoration(this.context, RecyclerView.VERTICAL))
        }
        subscribeViewModel(allPostAdapter)

    }


    private fun subscribeViewModel(allPostAdapter: FavoritePostAdapter) {
        viewModel.allFavoritePostLiveData.observe(viewLifecycleOwner) {
            allPostAdapter.submitList(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_post_fragment, container, false)
    }


}