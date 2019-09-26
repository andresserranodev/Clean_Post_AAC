package com.puzzle.bench.post_aac.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.puzzle.bench.post_aac.R
import com.puzzle.bench.post_aac.presentation.di.ViewModelInjector
import com.puzzle.bench.post_aac.presentation.viewmodels.PostDetailViewModel
import kotlinx.android.synthetic.main.post_details_fragment.*

class PostDetailFragment : Fragment() {

    private val args: PostDetailFragmentArgs by navArgs()

    private val viewModel: PostDetailViewModel by viewModels {
        ViewModelInjector.providePostDetailsViewModel(requireContext(), args.postId, args.userId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateStatus()
        viewModel.fetchComments()
        viewModel.postInfoLiveData.observe(viewLifecycleOwner) {
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_details_fragment, container, false)
    }
}