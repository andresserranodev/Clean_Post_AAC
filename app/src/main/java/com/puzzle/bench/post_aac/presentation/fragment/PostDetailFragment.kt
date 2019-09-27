package com.puzzle.bench.post_aac.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.databinding.PostDetailsFragmentBinding
import com.puzzle.bench.post_aac.presentation.adapter.CommentsAdapter
import com.puzzle.bench.post_aac.presentation.di.ViewModelInjector
import com.puzzle.bench.post_aac.presentation.viewmodels.PostDetailViewModel
import kotlinx.android.synthetic.main.post_details_fragment.toolbar


const val ADD_FAVORITE_MENU_POSITION = 1
const val REMOVE_FAVORITE_MENU_POSITION = 0

class PostDetailFragment : Fragment() {

    private val args: PostDetailFragmentArgs by navArgs()

    private val viewModelPostDetail: PostDetailViewModel by viewModels {
        ViewModelInjector.providePostDetailsViewModel(requireContext(), args.postId, args.userId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<PostDetailsFragmentBinding>(
            inflater,
            R.layout.post_details_fragment,
            container,
            false
        )
            .apply {
                viewModel = viewModelPostDetail
                lifecycleOwner = viewLifecycleOwner

                val adapterComments = CommentsAdapter()
                commentsListRv.apply {
                    adapter = adapterComments
                    addItemDecoration(DividerItemDecoration(this.context, RecyclerView.VERTICAL))
                }
                toolbar.setNavigationOnClickListener { view ->
                    view.findNavController().navigateUp()
                }
                toolbar.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.add_to_favorite -> {
                            viewModelPostDetail.maskAsAFavorite()
                            true
                        }
                        R.id.remove_to_favorite -> {
                            viewModelPostDetail.removeFromFavorite()
                            true
                        }
                        else -> false
                    }
                }
                viewModelPostDetail.updateStatus()
                viewModelPostDetail.postInfoLiveData.observe(viewLifecycleOwner) {
                    if (it.isFavorite) {
                        renderRemoveFavoriteMenuItem()
                    } else {
                        renderAddFavoriteMenuItem()
                    }
                }
                viewModelPostDetail.commentsLiveData.observe(viewLifecycleOwner) {
                    if (it.isEmpty()) {
                        viewModelPostDetail.fetchComments()
                    } else {
                        adapterComments.submitList(it)
                        commentsProgressbar.visibility = View.GONE
                    }
                }
            }
        return binding.root
    }

    private fun renderAddFavoriteMenuItem() {
        toolbar.menu[ADD_FAVORITE_MENU_POSITION].isVisible = true
        toolbar.menu[REMOVE_FAVORITE_MENU_POSITION].isVisible = false
    }

    private fun renderRemoveFavoriteMenuItem() {
        toolbar.menu[REMOVE_FAVORITE_MENU_POSITION].isVisible = true
        toolbar.menu[ADD_FAVORITE_MENU_POSITION].isVisible = false
    }
}