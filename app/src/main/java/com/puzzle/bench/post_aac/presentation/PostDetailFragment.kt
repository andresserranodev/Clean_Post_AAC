package com.puzzle.bench.post_aac.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.presentation.di.ViewModelInjector
import com.puzzle.bench.post_aac.presentation.viewmodels.PostDetailViewModel
import kotlinx.android.synthetic.main.post_details_fragment.*
import kotlinx.android.synthetic.main.post_details_fragment.toolbar


const val ADD_FAVORITE_MENU_POSITION = 1
const val REMOVE_FAVORITE_MENU_POSITION = 0

class PostDetailFragment : Fragment() {

    private val args: PostDetailFragmentArgs by navArgs()

    private val viewModel: PostDetailViewModel by viewModels {
        ViewModelInjector.providePostDetailsViewModel(requireContext(), args.postId, args.userId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.add_to_favorite -> {
                    viewModel.maskAsAFavorite()
                    true
                }
                R.id.remove_to_favorite -> {
                    viewModel.removeFromFavorite()
                    true
                }
                else -> false
            }
        }
        viewModel.updateStatus()
        viewModel.fetchComments()
        viewModel.postInfoLiveData.observe(viewLifecycleOwner) {
            if (it.isFavorite) {
                renderRemoveFavoriteMenuItem()
            } else {
                renderAddFavoriteMenuItem()
            }
            body_tv.text = it.body
        }
        viewModel.userInfoLiveData.observe(viewLifecycleOwner) {
            name_tv.text = it.name
        }
        viewModel.commentsLiveData.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                viewModel.fetchComments()
            } else {
                comment_tv.text = it[0].body
            }
        }

    }

    private fun renderAddFavoriteMenuItem() {
        toolbar.menu[ADD_FAVORITE_MENU_POSITION].isVisible = true
        toolbar.menu[REMOVE_FAVORITE_MENU_POSITION].isVisible = false
    }

    private fun renderRemoveFavoriteMenuItem() {
        toolbar.menu[REMOVE_FAVORITE_MENU_POSITION].isVisible = true
        toolbar.menu[ADD_FAVORITE_MENU_POSITION].isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_details_fragment, container, false)
    }
}