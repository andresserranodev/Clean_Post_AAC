package com.puzzle.bench.post_aac.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.databinding.AllPostFragmentBinding
import com.puzzle.bench.post_aac.presentation.adapter.AllPostAdapter
import com.puzzle.bench.post_aac.presentation.di.ViewModelInjector
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModel

class AllPostFragment : Fragment() {

    private lateinit var binding: AllPostFragmentBinding

    private val viewModel: AllPostViewModel by viewModels {
        ViewModelInjector.provideAllPostViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = AllPostFragmentBinding.inflate(inflater, container, false)
        val allPostAdapter = AllPostAdapter()
        binding.postListRv.apply {
            adapter = allPostAdapter
            addItemDecoration(DividerItemDecoration(this.context, VERTICAL))
        }
        subscribeViewModel(allPostAdapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel.getAllPost()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_post, menu)
    }

    private fun subscribeViewModel(allPostAdapter: AllPostAdapter) {
        viewModel.getPostLiveData().observe(::getLifecycle) {
            allPostAdapter.submitList(it)
        }
    }
}