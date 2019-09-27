package com.puzzle.bench.post_aac.presentation.fragment

import android.os.Bundle
import android.view.*
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.databinding.AllPostFragmentBinding
import com.puzzle.bench.post_aac.presentation.callbacks.SwipeToDeleteCallback
import com.puzzle.bench.post_aac.presentation.workers.SycDataWorker
import com.puzzle.bench.post_aac.presentation.adapter.AllPostAdapter
import com.puzzle.bench.post_aac.presentation.di.ViewModelInjector
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModel

class AllPostFragment : Fragment() {

    private lateinit var binding: AllPostFragmentBinding

    private val viewModel: AllPostViewModel by viewModels {
        ViewModelInjector.provideAllPostViewModel(requireContext())
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
        binding.deleteAllPostFb.setOnClickListener {
            viewModel.deleteAll()
        }
        subscribeViewModel(allPostAdapter)
        initDeleteSwiped()
        return binding.root
    }


    private fun initDeleteSwiped() {
        val swipeHandler = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.allPostLiveData.value?.get(viewHolder.adapterPosition)?.postId?.let {
                    viewModel.deletePost(it)
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.postListRv)

    }

    private fun refreshData() {
        this.context?.let {
            if (binding.postListRv.isEmpty()) {
                renderLoaderState()
                val request = OneTimeWorkRequestBuilder<SycDataWorker>().build()
                WorkManager.getInstance(it).enqueue(request)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_post, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh -> {
                refreshData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribeViewModel(allPostAdapter: AllPostAdapter) {
        viewModel.allPostLiveData.observe(viewLifecycleOwner) {
            allPostAdapter.submitList(it)
            renderLoadDataState()
        }
    }

    private fun renderLoaderState() {
        binding.progressBar.visibility = View.VISIBLE
        binding.deleteAllPostFb.visibility = View.GONE
    }

    private fun renderLoadDataState() {
        binding.progressBar.visibility = View.GONE
        binding.deleteAllPostFb.visibility = View.VISIBLE

    }
}