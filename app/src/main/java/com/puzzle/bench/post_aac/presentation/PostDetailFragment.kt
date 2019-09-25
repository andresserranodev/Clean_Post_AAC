package com.puzzle.bench.post_aac.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.puzzle.bench.post_aac.R
import kotlinx.android.synthetic.main.post_details_fragment.*

class PostDetailFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = PostDetailFragmentArgs.fromBundle(it)
            detail_tv.text = safeArgs.postId
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